package com.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author czy
 * @date 2021/6/9
 */
public class Test12 {
    public static void main(String[] args) throws NoSuchFieldException {
        Annotation[] annotations = E.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Table table = E.class.getAnnotation(Table.class);
        System.out.println(table);
        System.out.println("=========================================");
        Field[] declaredFields = E.class.getDeclaredFields();
        for (Field field : declaredFields) {
            Annotation[] annotation = field.getAnnotations();
            for (Annotation annotation1 : annotation) {
                System.out.println(annotation1);

            }
        }
        Field name = E.class.getDeclaredField("name");
        Filed annotation = name.getAnnotation(Filed.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Table("student")
class E {
    @Filed(columnName = "name", type = "varchar", length = 5)
    private String name;
    @Filed(columnName = "id", type = "int", length = 2)
    private int id;
    @Filed(columnName = "age", type = "int", length = 3)
    private int age;

    public E() {
    }

    public E(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "E{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Filed {
    String columnName() default "";

    String type();

    int length();
}