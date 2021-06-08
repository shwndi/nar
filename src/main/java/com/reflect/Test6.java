package com.reflect;

/**
 *
 * @author czy
 * @date 2021/6/8
 */
public class Test6 {
    static {
        System.out.println("main()被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
         //主动引用
        // D d = new D();
        //反射也会产生主动引用
        //Class.forName("com.reflect.D")    ;
        //不会产生类的引用的方法
        //System.out.println(D.b);
        //开辟数组空间没有加载类
       // D[] ds = new D[5];
        //常量在链接阶段就存入调用类的常量池中了，调用不会发生初始化
        System.out.println(D.M);
    }
}
class C{
    static int b =2;
    static{
        System.out.println("C类被加载");
    }
}
class D extends C{
    static{
        System.out.println("D类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M =1;
}
