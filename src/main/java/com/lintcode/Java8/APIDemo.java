package com.lintcode.Java8;

import com.lintcode.Utils.CommonUtils;

import java.util.*;
import java.util.stream.Collectors;

public class APIDemo {

    public static void main(String[] args) {
        //过滤
        List<String> strs = Arrays.asList("abc","","bc","sdas");
        List<String> res = strs.stream().filter(string -> !string.isEmpty()).map(s->s+"a").collect(Collectors.toList());
        System.out.println(Arrays.toString(res.toArray()));

        //forEach
        Random rand = new Random();
        rand.ints().limit(10).forEach(System.out::println);

        //map
        List<Integer> nums = Arrays.asList(3,2,4,3,1,1);
        nums.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        //sorted
        Random rand1 = new Random();
        rand1.ints().limit(10).sorted().forEach(System.out::println);

        //parallel
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();

        //获取统计结果
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        //Optional
        Integer value1 = null;

        //Optional.ofNullable - 允许传递为 null 参数
        Integer a = Optional.ofNullable(value1).orElse(12);
        System.out.println(a);

        //flatMap
        //错误返回
        String[] words = new String[]{"Hello","World"};
        List<String[]> res1 = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        res1.forEach(System.out::print);
        System.out.println();

        //正确版本
        List<String> res2 = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        res2.forEach(System.out::print);
    }
}
