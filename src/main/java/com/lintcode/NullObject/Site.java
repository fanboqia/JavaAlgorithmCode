package com.lintcode.NullObject;

public class Site {

    private Customer _customer;

    public Customer get_customer() {
        return _customer;
    }

    public void set_customer(Customer _customer) {
        this._customer = _customer;
    }

    public Customer getCustomer(){
        return _customer == null ? Customer.newNull():_customer;
    }

    public static void main(String[] args){
        Site site = new Site();
        System.out.println(site.getCustomer().getName());
        site.set_customer(new Customer("frank"));
        System.out.println(site.getCustomer().getName());
    }
}
