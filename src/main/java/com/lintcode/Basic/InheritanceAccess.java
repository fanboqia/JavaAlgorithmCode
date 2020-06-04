package com.lintcode.Basic;

public class InheritanceAccess {
    protected void func(){};
}

//子类权限大于等于父类权限（父类private方法不能访问）
class A2 extends InheritanceAccess{

    @Override
    public void func() {
        super.func();
    }

    public static void main(String[] args) {

    }
}
