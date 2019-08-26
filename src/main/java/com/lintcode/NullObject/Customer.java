package com.lintcode.NullObject;

public class Customer {

    private String name;

    public Customer(){

    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Customer newNull(){
        return new NullCustomer();
    }
}
