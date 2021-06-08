package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author czy
 * @date 2021/6/8
 */
public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("com.reflect.User");

        String name = clazz.getName();
        String simpleName = clazz.getSimpleName();
        Package pkg = clazz.getPackage();
        System.out.println(name);
        System.out.println(simpleName);
        System.out.println(pkg);
        //获得public方法
        Field[] field1 = clazz.getFields();
        //获得所有方法
        Field[] declaredFields = clazz.getDeclaredFields();
        //获得指定属性的值
        try {
            Field fieldName = clazz.getDeclaredField("name");
            System.out.println(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //获得类的方法
        System.out.println("============================");
        //获得公共的方法：本类和父类
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("public:"+method);
        }
        //获得自身的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethod:" +declaredMethod);
        }
        //获得指定的放法
        try {
            Method getNames = clazz.getMethod("getName", null);
            Method setName = clazz.getMethod("setName", String.class);
            System.out.println(getNames);
            System.out.println(setName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //获得构造器
        System.out.println("===========================");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor"+constructor);
        }

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor:"+declaredConstructor);
        }
    }
}
