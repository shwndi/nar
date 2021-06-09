package com.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型
 *
 * @author czy
 * @date 2021/6/9
 */
public class Test11 {
    public void test1(Map<String, User> map, List<User> list) {
        System.out.println("test1");
    }

    public Map<String, User> test2() {
        System.out.println("test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test1 = Test11.class.getDeclaredMethod("test1", Map.class, List.class);
        Type[] parameterTypes = test1.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println("parameterType"+parameterType);
            if (parameterType instanceof ParameterizedType){
                //获取真实参数类型
                Type[] actualTypeArguments = ((ParameterizedType) parameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }

        }

        System.out.println("==============================================");
        System.out.println("                  华丽的分割线");
        System.out.println("==============================================");

        Method test2 = Test11.class.getDeclaredMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        System.out.println(genericReturnType);
        if (genericReturnType instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type type : types) {
                System.out.println(type);
            }
        }
    }


}
