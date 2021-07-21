package com.tarknaiev.home_6_collections_my_collection;

import com.tarknaiev.home_6_collections_my_collection.mylist.MyList;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> testList = new MyList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        System.out.println(testList);

        testList.set(0,3);
        System.out.println(testList);

        System.out.println(testList.getSize());
    }
}
