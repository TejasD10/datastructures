package com.zzz.tutorial.java8;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UpperCaseTest {

    @Test
    public void shouldConvertElementsOfListToUpperCase() {
        List<String> input = Arrays.asList("programming", "is", "goood");
        List<String> output = Arrays.asList("PROGRAMMING", "IS", "GOOOD");
        Assertions.assertThat(output).hasSameElementsAs(JavaStreamPractice.transform(input));
    }
}
