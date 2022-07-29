package com.zzz.tutorial.java8;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Create an infinite series of prime numbers
 */
public class InfinitePrimesLazily {

    private static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(div -> number % div == 0);
    }

    private static int getPrime(int number) {
        if (isPrime(number + 1))
            return number + 1;
        else
            return getPrime(number + 1);
    }

    private static List<Integer> primes(int seed, int count) {
        return Stream.iterate(getPrime(seed - 1), InfinitePrimesLazily::getPrime)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(InfinitePrimesLazily.primes(1, 1000));
    }
}
