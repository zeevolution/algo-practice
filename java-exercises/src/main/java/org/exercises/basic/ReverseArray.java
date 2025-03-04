package org.exercises.basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseArray {

    /*
     * An array is a data structure that stores elements of the same type in a contiguous block of memory.
     * In an array,A, of size N, each memory location has some unique index,  i (where 0 <= i < N),
     * that can be referenced as A[i] or Ai.
     *
     * Your task is to reverse an array of integers.
     *
     * Example
     * A = [1, 2, 3]
     * Return [3, 2, 1].
     *
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static List<Integer> reverseArray(final List<Integer> array) {
        // Write your code here
        List<Integer> mutableReversedArray = new ArrayList<>(array);

        for (int i = array.size() - 1; i >= 0; i--) {
            mutableReversedArray.remove(i);
            mutableReversedArray.add(array.get(i));
        }
        return mutableReversedArray;
    }

    final static class ReverseArrayTest {

        @Test
        void shouldReturnReversedArrayForGivenNonEmptyArrayTest() {
            // arrange
            final List<Integer> array = List.of(1, 2, 3, 4);
            final List<Integer> expectedReversedArray = List.of(4, 3, 2, 1);

            // act
            final List<Integer> actualReversedArray = reverseArray(array);

            // assert
            assertEquals(expectedReversedArray.toString(), actualReversedArray.toString());
        }

        @Test
        void shouldReturnEmptyArrayForGivenEmptyArrayTest() {
            // arrange
            final List<Integer> emptyArray = Collections.emptyList();
            final List<Integer> expectedReversedArray = Collections.emptyList();

            // act
            final List<Integer> actualEmptyReversedArray = reverseArray(emptyArray);

            // assert
            assertEquals(expectedReversedArray.toString(), actualEmptyReversedArray.toString());
        }
    }
}
