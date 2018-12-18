package com.zzz.tutorial.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaExplore {
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        /**
         * The below snippet of code returns the flattened list of integers
         * 1,2,3,4,5,6
         */
        List<Integer> reduceList = lists.stream()
                .flatMap(arr -> arr.stream())
//                .peek(System.out::println)
                .collect(Collectors.toList());
        reduceList.forEach(System.out::print);

    }
}
