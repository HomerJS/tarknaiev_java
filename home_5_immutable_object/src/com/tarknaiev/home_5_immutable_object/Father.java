package com.tarknaiev.home_5_immutable_object;

/**
 * The type Father.
 */
public class Father {
    private String name;
    private int age;

    /**
     * Instantiates a new Father.
     */
    public Father() {
        this.name = "John doe";
        this.age = 0;
    }

    /**
     * Instantiates a new Father.
     *
     * @param name the name
     * @param age  the age
     */
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
