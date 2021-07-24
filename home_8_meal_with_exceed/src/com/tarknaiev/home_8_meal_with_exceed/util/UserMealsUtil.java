package com.tarknaiev.home_8_meal_with_exceed.util;

import com.tarknaiev.home_8_meal_with_exceed.model.UserMeal;
import com.tarknaiev.home_8_meal_with_exceed.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UserMealsUtil {
    public void run() {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> result = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
    }

    public List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int averageCaloriesPerDay) {
        Map<LocalDate, Integer> caloriesPerDay = mealList.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getDateTime().toLocalDate(),
                        summingInt(UserMeal::getCalories)
                ));


        Map<LocalDateTime, UserMealWithExceed> result = mealList.stream()
                .filter(x -> TimeUtil.isBetween(x.getDateTime().toLocalTime(), startTime, endTime))
                .collect(Collectors.toMap(
                        UserMeal::getDateTime,
                        x -> new UserMealWithExceed(
                                x.getDateTime(),
                                x.getDescription(),
                                x.getCalories(),
                                caloriesPerDay.get(x.getDateTime().toLocalDate()) > averageCaloriesPerDay)
                ));
        return new ArrayList<>(result.values());
    }
}
