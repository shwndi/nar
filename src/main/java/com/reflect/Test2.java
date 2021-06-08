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
}
