package com.tarknaiev.home_7_streams;

import java.util.Arrays;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{-40, 83, -94, 40, -80, 96, 10, -79, -72, -26, 0};

//        1. Найти среднее значение элементов массива
        double average = Arrays.stream(array).average().getAsDouble();
        System.out.println(average);

//        2. Найти минимальный элемент, значение и индекс
        OptionalInt index = IntStream.range(0, array.length).reduce((a1, a2) -> array[a1] < array[a2] ? a1 : a2);
        System.out.println("index = " + index.getAsInt() + ", value =  " + array[index.getAsInt()]);


//        3. Посчитать количество элементов равных нулю
        long zeroCounter = Arrays.stream(array)
                .filter(x -> x == 0)
                .count();
        System.out.println(zeroCounter);

//        4. Посчитать количество элементов больше нуля
        long moreThenZeroCounter = Arrays.stream(array)
                .filter(x -> x > 0)
                .count();
        System.out.println(moreThenZeroCounter);

//        5. Помножить элементы массива на число
        Arrays.stream(array)
                .map(x -> x * -1)
                .forEach(System.out::println);
    }
}
