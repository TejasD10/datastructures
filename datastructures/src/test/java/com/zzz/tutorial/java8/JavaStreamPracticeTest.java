package com.zzz.tutorial.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class JavaStreamPracticeTest {

    @Test
    public void shouldConvertElementsOfListToUpperCase() {
        List<String> input = Arrays.asList("programming", "is", "goood");
        List<String> output = Arrays.asList("PROGRAMMING", "IS", "GOOOD");
        assertThat(output).hasSameElementsAs(JavaStreamPractice.transform(input));
    }

    @Test
    public void shouldReturnElementsWithLessThan4Chars() {
        List<String> input = Arrays.asList("programming", "is", "goood");
        List<String> output = Arrays.asList("is");
        assertThat(output).hasSameElementsAs(JavaStreamPractice.transformToLessThan4Chars(input));
    }

    @Test
    public void shouldReturnOldestPerson() {

    }
}
