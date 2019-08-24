package com.lintcode.polymorphism;

public class Employee {

    private EmployType _type;

    public EmployType get_type() {
        return _type;
    }

    public void set_type(EmployType _type) {
        this._type = _type;
    }

    public int getPayAmount(){
        return _type.getPayAmount(this);
    }

    public int getMonthlySalary(){
        return _type.getMonthlySalary();
    }

    public Employee(EmployType _type) {
        this._type = _type;
    }

    public static void main(String[] args){
        Employee e1 = new Employee(new Engineer());
        System.out.println(e1.getPayAmount());
        Employee e2 = new Employee(new Saleman());
        System.out.println(e2.getPayAmount());
    }
}
