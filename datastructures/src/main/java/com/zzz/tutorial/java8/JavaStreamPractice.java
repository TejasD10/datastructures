package com.zzz.tutorial.java8;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamPractice {
    public static List<String> transform(List<String> input) {
        return input.stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<String> transformToLessThan4Chars(List<String> input) {
        return input.stream()
                .filter(item -> item.length() < 4)
                .collect(Collectors.toList());
    }
    private static class Person {

    }
}
