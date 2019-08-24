package com.lintcode.polymorphism;

public class Engineer extends EmployType{

    @Override
    int getPayAmount(Employee e) {
        return e.getMonthlySalary() + 100;
    }

    @Override
    int getMonthlySalary() {
        return 2000;
    }
}
