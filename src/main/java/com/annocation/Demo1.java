package com.annocation;

import java.util.ArrayList;
import java.util.List;

/**
 * 内置注解
 *
 * @author czy
 * @date 2021/6/8
 */
public class Demo1 {
    //代表已过时的
    @Deprecated
    public void warring1(){

    }
    //代表取消警告
    @SuppressWarnings("unchecked")
    public void warring2(){
      List list= new ArrayList();
    }
    //重写方法
    @Override
    public String toString() {
        return "Demo1{}";
    }
}
