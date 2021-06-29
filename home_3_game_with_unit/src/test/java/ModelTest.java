import com.tarknaiev.home_3_game_with_unit.Model;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author ihor
 */
public class ModelTest {
    protected Model model;
    
    @BeforeEach
    public void initEach(){
        model = new Model();
    }
    
    /**
     * test startNewGame for skipping all data
     */
    @Test
    public void testStartNewGame() {
        try {
            ReflectionTestUtils.setField(this.model, "isFinished", true);
            ReflectionTestUtils.setField(this.model, "minRange", 10);
            ReflectionTestUtils.setField(this.model, "maxRange", 50);
            this.model.StartNewGame();
            Assert.assertTrue(this.model.IsFinished() == false);
            Field maxRangeField = this.model.getClass().getDeclaredField("maxRange");
            Field minRangeField = this.model.getClass().getDeclaredField("minRange");
            maxRangeField.setAccessible(true);
            minRangeField.setAccessible(true);
            Assert.assertTrue(maxRangeField.getInt(this.model) == this.model.MAX_VALUE);
            Assert.assertTrue(minRangeField.getInt(this.model) == this.model.MIN_VALUE);
        } catch (Exception ex) {
            Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * test randomizer
     */
    @Test
    public void testStartNewGameRandomizer() {
        int testInteration = 10000;
        for(int i=0; i< testInteration;++i) {
            try {
                this.model.StartNewGame();
                Field randomField = this.model.getClass().getDeclaredField("randNumber");
                randomField.setAccessible(true);
                int randomNumber = randomField.getInt(this.model);
                Assert.assertTrue(randomNumber >=0 && randomNumber <=100);
            } catch (Exception ex) {
                Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Test
    public void testCheckNewDataValidationError() {
        String result = this.model.CheckNewData(-30);
        Assert.assertEquals(this.model.ERROR_VALIDATION_MESSAGE, result);
    }
    
    @Test
    public void testCheckNewDataIsFinished() {
        try {
            this.model.StartNewGame();
            Field randomField = this.model.getClass().getDeclaredField("randNumber");
            randomField.setAccessible(true);
            int randomNumber = randomField.getInt(this.model);
            String result = this.model.CheckNewData(randomNumber);
            Assert.assertEquals(this.model.GAME_HAS_FINISHED_MESSAGE, result);
        } catch (Exception ex) {
            Logger.getLogger(ModelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     class MockModelClass extends Model{
       @Override 
       public boolean ValidateNewData(int value){
           this.maxRange = 100;
           return super.ValidateNewData(value);
       }
       
       public boolean IsValueTheSame(int value){
           this.randNumber = value;
           return super.IsValueTheSame(value);
       }
       
       public void SetNewRanges(int value) {
           super.SetNewRanges(value);
       }
       
   }

    @Test
    public void testValidateNewData() {
        int test1 = 10;
        int test2 = 90;
        int test3 = -90;
        int test4 = 150;
        MockModelClass mc = Mockito.mock(MockModelClass.class);
        Mockito.when(mc.ValidateNewData(test1)).thenCallRealMethod();
        Mockito.when(mc.ValidateNewData(test2)).thenCallRealMethod();
        Mockito.when(mc.ValidateNewData(test3)).thenCallRealMethod();
        Mockito.when(mc.ValidateNewData(test4)).thenCallRealMethod();
        Assert.assertTrue(mc.ValidateNewData(test1));
        Assert.assertTrue(mc.ValidateNewData(test2));
        Assert.assertFalse(mc.ValidateNewData(test3));
        Assert.assertFalse(mc.ValidateNewData(test4));
    }
    
    @Test
    public void testIsValueTheSame(){
        MockModelClass mc = Mockito.mock(MockModelClass.class);
        Mockito.when(mc.IsValueTheSame(10)).thenCallRealMethod();
        Mockito.when(mc.IsValueTheSame(20)).thenCallRealMethod();
        Mockito.when(mc.IsValueTheSame(30)).thenCallRealMethod();
        Assert.assertTrue(mc.IsValueTheSame(10));
        Assert.assertTrue(mc.IsValueTheSame(20));
        Assert.assertTrue(mc.IsValueTheSame(30));
    }

    @Test
    public void testIsFinished() {
        ReflectionTestUtils.setField(this.model, "isFinished", true);
        Assert.assertTrue(this.model.IsFinished());
        ReflectionTestUtils.setField(this.model, "isFinished", false);
        Assert.assertFalse(this.model.IsFinished());
    }
}
