package com.lintcode.polymorphism;

public class Saleman extends EmployType{

    @Override
    int getPayAmount(Employee e) {
        return e.getMonthlySalary() + 200;
    }

    @Override
    int getMonthlySalary() {
        return 1000;
    }
}
