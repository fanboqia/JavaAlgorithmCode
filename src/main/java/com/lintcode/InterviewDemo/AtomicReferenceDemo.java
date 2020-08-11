package com.lintcode.InterviewDemo;

import java.util.concurrent.atomic.AtomicReference;

class User{
    public String name;
    public int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User a = new User("a",22);
        User b = new User("b",25);
        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(a);

        System.out.println(atomicReference.compareAndSet(a,b)+" "+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(a,b)+" "+atomicReference.get().toString());
    }
}
