package org.exercises.basic;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleArraySum {

    /**
     *
     * Given an array of integers, find the sum of its elements.
     * For example, if the array = [1, 2, 3]. 1 + 2 + 3 = 6, so return 6.
     *
     */
    public static int simpleArraySum(List<Integer> array) {
        return array.stream().reduce(0, Integer::sum);
    }

    static class SimpleArraySumTest {
        @Test
        void shouldReturnExpectedArraySumForGivenNonEmptyIntegerArrayTest() {
            // arrange
            final List<Integer> integers = List.of(1, 2, 3, 4, 5);
            final int expectedSumValue = 15; // 1 + 2 + 3 + 4 + 5 = 15

            // act
            int actualSumValue = simpleArraySum(integers);

            // assert
            assertEquals(expectedSumValue, actualSumValue);
        }

        @Test
        void shouldReturnZeroSumForGivenEmptyIntegerArrayTest() {
            // arrange
            final List<Integer> integers = new ArrayList<>();
            final int expectedSumValue = 0; // no integers in the list

            // act
            int actualSumValue = simpleArraySum(integers);

            // assert
            assertEquals(expectedSumValue, actualSumValue);
        }

        @Test
        void shouldReturnExpectedArraySumForLargeIntegerArrayTest() {
            // arrange
            final List<Integer> integers = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                integers.add(i);
            }

            // Sum = (n * (a1 +an) ) / 2 => Arithmetic Progression Formula
            // Sum = (1000 * (1 + 1000) ) / 2 = 500500
            final long expectedSumValue = 500500;

            // act
            int actualSumValue = simpleArraySum(integers);

            // assert
            assertEquals(expectedSumValue, actualSumValue);
        }
    }
}
