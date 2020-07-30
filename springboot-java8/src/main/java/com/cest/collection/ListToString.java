package com.cest.collection;

import com.sun.deploy.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToString {

    public static void main(String[] args) {

        System.out.println(StringUtils.join(Stream.of("1231","32131","2131231").collect(Collectors.toList()),","));
    }
}
