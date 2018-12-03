package com.zzz.tutorial.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonComparator {
    
    private static class Person {
        private final String name;
        private final int age;
        
        public Person(final String name, final int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public String toString() {
            return "name='" + name + '\'' + ", age=" + age;
        }
        
        public int ageDifference(final Person other) {
            return age - other.age;
        }
    }
    
    public static void main(String args[]) {
        List<Person> people = Arrays.asList(
                new Person("Greg", 35),
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21));
        // Older way of doing Comparators
        /*
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        */
        
        // Reduce the ceremony using lambdas
        /*
       people.sort((p1, p2) -> p1.age - p2.age);
       */
        
        //Using Comparator instead
        /*
        people.sort(Comparator.comparingInt(Person::getAge));
        */
        
        /*
        Since the sort() method is really mutating the original list
        we'd rather use a stream to keep the original list and generate a new list
        sorted by the desired comparator
        
        You can use method refernces when yo want the compiler to treat
        the first parameter as the target and the rest as the arguments
        like in the case below
        Person::ageDiffernece - The first person will be the target and the second person will be the argument
         */
        /*
        List<Person> ascendingAge = people.stream()
                                            .sorted(Person::ageDifference)
                                            .collect(Collectors.toList());
        ascendingAge.forEach(System.out::println);
        */
        
        //Using the same comparator to sort in descending order of age
        List<Person> ageDescending = people.stream()
                                             .sorted((p1, p2) -> p2.ageDifference(p1))
                                             .collect(Collectors.toList());
        ageDescending.forEach(System.out::println);
        
        
        /*
        Find the youngest person in the people's list
        Using min which takes a comparator and reduces down to one element
         */
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(p1 -> System.out.println("Youngest: " + p1));
        
        /*
        Group the people in the person list by their age
        In this case, you can use the collectors.groupingBy to do the same
         */
        Map<Integer, List<Person>> peopleByAge = people.stream()
                                                         .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("People grouped by age: " + peopleByAge);
        
        /*
        Instead of using the above syntax where we are only grouping each person by their age
        We can also use a different mapping/reducing for each bucket.
         */
        System.out.println("\n\nFor each, get the first name of the person");
        Map<Integer, List<Character>> firstNameByAge = people.stream()
                                                               .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(p -> p.getName().charAt(0), Collectors.toList())));
        System.out.println(firstNameByAge);
        
        
    }
}
