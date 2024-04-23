package oop;

import java.util.ArrayList;
import java.util.List;

class MyClass implements Cloneable {
    int num = 1;
    List<Integer> list = new ArrayList<>() {
        {
            add(1);
        }
    };

    @Override
    public MyClass clone() throws CloneNotSupportedException {
        return (MyClass) super.clone();
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "num=" + num +
                ", list=" + list +
                '}';
    }
}

public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass origin = new MyClass();
        MyClass copy = origin.clone();

        System.out.println("Origin: " + origin);
        System.out.println("Copy: " + copy);

        origin.num = 2;
        origin.list.add(2);

        System.out.println("Origin: " + origin);
        System.out.println("Copy: " + copy);
    }
}



