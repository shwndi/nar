package com.annocation;

import java.lang.annotation.*;

/**
 * 元注解：Target:描述注解的使用范围；
 *         Retention：表示需要在什么级别使用该注解，描述注解的生命周期（SOURCE<CLASS<RUNTIME）；
 *         Documented:说明该注解将被包含在javadoc中;
 *         Inherited:说明子类可以继承父类注解.
 * @author czy
 * @date 2021/6/8
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo2 {
    /**
     * 一个参数使用value
     * 设置默认值
     * @return
     */
    String[] value() default "";
int num() default 0;
}

class test{
    @Demo2(value = "asd",num = 21)
    public void test(){

    }
}