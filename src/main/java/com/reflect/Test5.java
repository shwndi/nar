package com.reflect;

/**
 * @author czy
 * @date 2021/6/8
 */
public class Test5 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}
class A{
    static{
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;
    public A(){
        System.out.println("A类的无参构造初始化");
    }
}
