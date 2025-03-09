package org.exercises.basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftRotation {

    /*
     * A left rotation operation on a circular array shifts each of the array's elements 1 unit to the left.
     * The elements that fall off the left end reappear at the right end.
     * Given an integer d, rotate the array that many steps to the left and return the result.
     * Example
     * d = 2
     * arr = [1, 2, 3, 4, 5]
     *
     * After 2 rotations, arr' = [3, 4, 5, 1, 2].
     *
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        while (d >= 1) {
            final Integer itemToRotate = arr.get(0);
            arr.add(itemToRotate);
            arr.remove(0);
            d--;
        }

        return arr;
    }

    final static class HourglassSumTest {

        @Test
        void shouldRotateArrayGivenNumberOfStepsTest() {
            // arrange
            final List<Integer> array = new ArrayList<>(List.of(1, 2, 3, 4, 5));
            final int numberOfSteps = 4;
            final String expectedRotatedArray  = "[5, 1, 2, 3, 4]";

            //act
            final List<Integer> actualRotatedArray = rotateLeft(numberOfSteps, array);

            //assert
            assertEquals(expectedRotatedArray, actualRotatedArray.toString());
        }

        @Test
        void shouldNotRotateArrayGivenZeroNumberOfStepsTest() {
            // arrange
            final List<Integer> array = new ArrayList<>(List.of(1, 2, 3, 4, 5));
            final int numberOfSteps = 0;
            final String expectedRotatedArray  = "[1, 2, 3, 4, 5]";

            //act
            final List<Integer> actualRotatedArray = rotateLeft(numberOfSteps, array);

            //assert
            assertEquals(expectedRotatedArray, actualRotatedArray.toString());
        }
    }
}
