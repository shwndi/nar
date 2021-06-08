package com.reflect;

/**
 * @author czy
 * @date 2021/6/8
 */
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+ person.name);
        //通过对象获得Class
        Class clazz = person.getClass();
        System.out.println(clazz.hashCode());
        //通过类路径获得Class
        Class clazz1 = Class.forName("com.reflect.Student");
        System.out.println(clazz1.hashCode());
        //通过类名.class获得Class
        Class clazz2 = Student.class;
        System.out.println(clazz2.hashCode());
        //基本内置类型的包装类都有一个Type属性
        Class clazz3 = Integer.TYPE;
        System.out.println(clazz3);
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

}
class Person{
    public String name;

    public Person() {
    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student() {
        this.name = "student";
    }
}
class Teacher extends Person{
    public Teacher() {
        this.name = "Teacher";
    }
}