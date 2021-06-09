package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author czy
 * @date 2021/6/9
 */
public class Test9 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("com.reflect.User");
//        //本质是调用了无参构造器
//        Constructor constructor = clazz.getDeclaredConstructor();
//        User user = (User) constructor.newInstance();
        User user = (User)clazz.newInstance();
        System.out.println(user);

        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) declaredConstructor.newInstance("asfhas", 12, 42);
        System.out.println(user1);

        System.out.println("==============================================");
        System.out.println("                  我是分割线");
        System.out.println("==============================================");

        Method setName = clazz.getDeclaredMethod("setName", String.class);
        //invoke:激活的意思
        //对象，方法的值
        setName.invoke(user,"八戒");
        System.out.println(user);

        Method setId = clazz.getDeclaredMethod("setId", int.class);
        Object invoke = setId.invoke(user, 22);
        System.out.println(user);
        System.out.println(invoke);


        System.out.println("==============================================");
        System.out.println("                  我是分割线");
        System.out.println("==============================================");

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"悟空");
        System.out.println(user);

    }
}
