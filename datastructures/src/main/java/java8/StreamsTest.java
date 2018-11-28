package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class StreamsTest {
    public static void main(String args[]) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> gt5 = numList.stream()
                .filter(item -> item > 5)
                .collect(Collectors.toList());
        gt5.stream().forEach(System.out::println);
        LongAdder adder = new LongAdder();
        System.out.println(numList.stream()
                .filter(item -> item > 5)

                .collect());

    }
}
