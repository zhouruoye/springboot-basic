package com.cest.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Sort {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        names.sort((a, b) -> a.compareTo(b));

        log.info(names.toString());


    }
}
