package com.reflect;

import javax.annotation.processing.SupportedSourceVersion;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author czy
 * @date 2021/6/9
 */
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        test1();
        test2();
        test3();

    }
    private static void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("==============================================");
        System.out.println("                  关闭检测反射分割线");
        System.out.println("==============================================");
        Class<?> clazz = Class.forName("com.reflect.User");
        User user2 = (User)clazz.newInstance();
        Method getName = clazz.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_0000_0000L; i++) {
            getName.invoke(user2,null);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    private static void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("==============================================");
        System.out.println("                  反射分割线");
        System.out.println("==============================================");

        Class clazz = Class.forName("com.reflect.User");
        User user1 = (User)clazz.newInstance();
        Method getName = clazz.getDeclaredMethod("getName");

        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_0000_0000L; i++) {
            getName.invoke(user1,null);
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    private static void test1() {
        System.out.println("==============================================");
        System.out.println("                  普通分割线");
        System.out.println("==============================================");

        User user = new User();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_0000_0000L; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
