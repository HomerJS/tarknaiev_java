package com.tarknaiev.home_5_immutable_object;

/**
 * The type Immutable student.
 */
public class ImmutableStudent {
    private final String name;
    private final int age;
    private final String group;
    private final Father father;

    /**
     * Instantiates a new Immutable student.
     */
    public ImmutableStudent() {
        this.name = "john doe";
        this.age = '0';
        this.group = "temp";
        this.father = new Father();
    }

    /**
     * Instantiates a new Immutable student.
     *
     * @param name   the name
     * @param age    the age
     * @param group  the group
     * @param father the father
     */
    public ImmutableStudent(String name, int age, String group, Father father) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.father = new Father(father.getName(), father.getAge());
    }

    @Override
    public int hashCode() {
        return (age + name + group).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof ImmutableStudent)) {
            return false;
        }
        ImmutableStudent temp = (ImmutableStudent) obj;
        return this.age == temp.age && name.equals(temp.name) && this.age == temp.age;
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
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets group.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Gets father.
     *
     * @return the father
     */
    public Father getFather() {
        return new Father(father.getName(), father.getAge());
    }
}
