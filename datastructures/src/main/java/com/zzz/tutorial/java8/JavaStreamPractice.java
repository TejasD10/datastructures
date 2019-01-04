package com.zzz.tutorial.java8;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamPractice {
    public static List<String> transform(List<String> input) {
        return input.stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList());
    }
}
