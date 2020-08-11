package com.lintcode.Java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//函数式接口4大接口
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //函数式接口匿名内部类实现
        Function<String,Integer> function = new Function<String,Integer>(){
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };
        function.apply("a");
        //最新
        Function<String,Integer> function1 = s -> {return 1024;};
        function1.apply("a");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        Predicate<String> predicate1 = s -> {return false;};
        predicate1.test("b");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "a";
            }
        };
        Supplier<String> supplier1 = ()->{return "a";};
        supplier1.get();

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> consumer1 = s -> {System.out.println(s);};
        consumer1.accept("a");
    }
}
