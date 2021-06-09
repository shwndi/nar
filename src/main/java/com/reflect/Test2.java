package com.reflect;

/**
 * @author czy
 * @date 2021/6/8
 */
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = null;
        try {
            clazz = Class.forName("com.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz.hashCode());
        System.out.println(Class.forName("com.reflect.User").hashCode());
        System.out.println(Class.forName("com.reflect.User").hashCode());
        System.out.println(Class.forName("com.reflect.User").hashCode());
    }
}
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
