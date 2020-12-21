package com.cest.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<String> collect = Stream.of("1","2","231","321").collect(Collectors.toList()).stream().limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }
}
