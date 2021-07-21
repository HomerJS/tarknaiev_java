package com.tarknaiev.home_6_collections_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> startArray = new ArrayList<>(Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7));

        Map<Integer, Integer> counter = new HashMap<>();
        for (int number : startArray) {
            int count = 1;
            if (counter.containsKey(number)) {
                count = counter.get(number) + 1;
            }

            counter.put(number, count);
        }

        System.out.println(counter);
    }
}
