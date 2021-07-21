package com.tarknaiev.home_6_collections_my_collection.mylist;

public class MyList<T> implements Iterable<T>{
    private T[] array;
    private int usedSize = 0;
    private int realSize = 0;

    public MyList() {
        this(16);
    }

    public MyList(int realSize) {
        this.realSize = realSize;
        array = (T[]) new Object[realSize];
    }

    public int getSize() {
        return usedSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void set(int index, T elem) {
        array[index] = elem;
    }

    public void add(T elem) {
        if (usedSize + 1 >= realSize) {
            if (realSize == 0) realSize = 1;
            else realSize *= 2;
            T[] new_array = (T[]) new Object[realSize];
            for (int i = 0; i < usedSize; i++) new_array[i] = array[i];
            array = new_array;
        }
        array[usedSize++] = elem;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < usedSize; i++) {
            if (obj == null) {
                if (array[i] == null) return i;
            } else {
                if (obj.equals(array[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < usedSize;
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (usedSize == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(usedSize).append("[");
            for (int i = 0; i < usedSize - 1; i++) sb.append(array[i] + ", ");
            return sb.append(array[usedSize - 1] + "]").toString();
        }
    }
}
