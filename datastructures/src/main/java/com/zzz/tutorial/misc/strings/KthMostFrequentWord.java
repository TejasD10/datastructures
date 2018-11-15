package com.zzz.tutorial.misc.strings;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.stream.IntStream;

public class KthMostFrequentWord {

    public static void main(String args[]) {
        String[] input = {"a", "b", "b"};
        System.out.println(kthMostFrequent(input, 1));
    }

    private static String kthMostFrequent(String[] input, int k) {
        // Boundary Checks
        if (input == null || input.length == 0 || k == 0)
            return null; // May be, you can return an empty string
        // Create a hashmap to store the frequencies
        Map<String, Integer> counts = new HashMap<>();

        Arrays.stream(input).forEach((item) -> {
            Integer curr = counts.getOrDefault(item, 0);
            counts.put(item, ++curr);
        });
        // Now we want to be able to sort it
        // Create a list of empty strings
        List<Map.Entry> listOfStrings = new ArrayList<>(counts.entrySet());

        Collections.sort(listOfStrings, (o1, o2) -> {
            // Get the values of the strings as Integers
            Integer v1 = (Integer) o1.getValue();
            Integer v2 = (Integer) o2.getValue();
            return v1.compareTo(v2);
        });
        System.out.println(listOfStrings);
        if (listOfStrings.size() > k) return String.valueOf(listOfStrings.get(k).getKey());
        return null;
    }
}
