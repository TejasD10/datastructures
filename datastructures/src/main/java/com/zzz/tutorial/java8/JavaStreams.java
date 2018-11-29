package com.zzz.tutorial.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {
    
    public static void main(String args[]) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        
        // 1. Instead of duplicating we can create an instance of a predicate and use it
        //final Predicate<String> filterWithN = name -> name.startsWith("N");
        
        // 3. We can create a Function and use it to return a predicate
        // to narrow the lexical scoping
        /*final Function<String, Predicate<String>> checkStartsWith =
                (String letter) -> {
                    final Predicate<String> predicate = (String name) -> name.startsWith(letter);
                    return predicate;
                };*/
        // Reduce the clutter
        final Function<String, Predicate<String>> checkStartsWith =
                letter -> name -> name.startsWith(letter);
        
        
        System.out.println("FriendsStartWithN: " + friends.stream()
                                                           .filter(checkStartsWith.apply("N"))
                                                           .count());
        System.out.println("EditorsStartWithN: " + editors.stream()
                                                           .filter(checkStartsWith.apply("N"))
                                                           .count());
        System.out.println("ComradesStartWithN: " + comrades.stream()
                                                            .filter(checkStartsWith.apply("N"))
                                                            .count());
        
        
        System.out.println();
        System.out.println();
        
        System.out.println("Find First with N & Z");
        final Optional<String> foundWithN = friends.stream()
                                                    .filter(name -> name.startsWith("N"))
                                                    .findFirst();
        System.out.println(foundWithN.orElse("No Name Found with N"));
        final Optional<String> foundWithZ = friends.stream()
                                                    .filter(name -> name.startsWith("Z"))
                                                    .findFirst();
        System.out.println(foundWithZ.orElse("No Name Found with Z"));
        
        
        System.out.println("\n\nReduce Example");
        longestName(friends);
        
        System.out.println("\n\nJoining via Collect");
        collect(friends);
        
    }
    
    /**
     * Collect the values and join them with a ","
     *
     * @param friends
     */
    private static void collect(List<String> friends) {
        System.out.println(
                friends.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", "))
        );
    }
    
    
    /**
     * Print the longest name in the stream using reduce
     *
     * @param friends
     */
    private static void longestName(List<String> friends) {
        final Optional<String> longestName =
                friends.stream()
                        .reduce((name1, name2) -> {
                            System.out.println(name1 + ":" + name2);
                            return name1.length() >= name2.length() ? name1 : name2;
                        });
        longestName.ifPresent(name -> System.out.println(name));
    }
    
    //2. If we want the letter to be parameterized we could use a function and return
    // a predicate
    // Static methods - :( We want to reduce clutter
//    private static Predicate<String> checkStartsWith(final String letter) {
//        return name -> name.startsWith(letter);
//    }
}
