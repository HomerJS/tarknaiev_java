package com.tarknaiev.home_2_junit;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;

/**
 *
 * @author ihor
 */
public class ArithmeticsTest {
    protected Arithmetics a;
    
        
    @BeforeEach
    public void initEach(){
        a = new Arithmetics();
    }
    
    /**
     * Test of add method, of class Arithmetics.
     */
    @Test
    public void testAdd() {
        double res = a.add(3, 7);
        if (res != 10) Assert.fail("Error ...");
        Assert.assertEquals(res, 10.0);
    }

    /**
     * Test of deduct method, of class Arithmetics.
     */
    @Test
    public void testDeduct() {
        double res = a.deduct(3, 7);
        Assert.assertTrue(res == -4);
    }

    /**
     * Test of mult method, of class Arithmetics.
     */
    @Disabled
    @Test
    public void testMult() {
        double res = a.mult(3, 7);
        Assert.assertFalse(res != 21);
    }
    
    /**
     * Test of div method, of class Arithmetics.
     */
    @Test
    public void testDiv() {
        Assert.assertNotNull(a);
        double res = a.div(10, 5);
        if (res != 2.0) Assert.fail();
    }
    
    /**
     * Test of div method, of class Arithmetics.
     */
    @Test
    @DisplayName("Testing NullPointerException")
    public void testDivException() {
        a.div(10.0, 0.0);
        
    }
    
    /**
     * Test of add timeout method, of class Arithmetics.
     */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testAddTimeout() {
        a.div(10.0, 0.0);
        
    }
    
    
}
