package com.zzz.tutorial.java8;

import java.util.function.Supplier;

/**
 * This class demonstrates how to create objects lazily
 */
public class LazyEvaluation {

    public static class Heavy {
        public Heavy() {
            System.out.println("Heavy created");
        }

        @Override
        public String toString() {
            return "Heavy Object Created";
        }
    }

    public static class HolderNaive {
        // This is the heavy object which should be created heavily
        private Heavy heavy;

        public HolderNaive() {
            System.out.println("Holder created");
        }

        public Heavy getHeavy() {
            if (heavy == null) {
                heavy = new Heavy();
            }
            return heavy;
        }
    }

    public static class HolderBetter {
        private Supplier<Heavy> heavy = this::createAndCacheHeavy;

        public HolderBetter() {
            System.out.println("Holder created");
        }

        public Heavy getHeavy() {
            return heavy.get();
        }

        private synchronized Heavy createAndCacheHeavy() {
            class HeavyFactory implements Supplier<Heavy> {
                private final Heavy heavyInstance = new Heavy();

                public Heavy get() {
                    return heavyInstance;
                }
            }
            if (!HeavyFactory.class.isInstance(heavy))
                heavy = new HeavyFactory();
            return heavy.get();
        }
    }

    public static void main(String[] args) {
        // Holder Naive
//        HolderNaive naive = new HolderNaive();
//        System.out.println(naive.getHeavy());
//        System.out.println(naive.getHeavy());

        HolderBetter better = new HolderBetter();
        System.out.println(better.getHeavy());
        System.out.println(better.getHeavy());
        System.out.println(better.getHeavy());

    }
}
