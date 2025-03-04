package org.exercises.basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourglassSum {

    /*
     * Given a 6x6 2D array, arr, an hourglass is a subset of values with indices falling in the following pattern:
     *
     * a b c
     *   d
     * e f g
     *
     * There are 16 hourglasses in a 6x6 array.
     * The hourglass sum is the sum of the values in an hourglass.
     * Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
     *
     *  -9 -9 -9  1 1 1
     *   0 -9  0  4 3 2
     *  -9 -9 -9  1 2 3
     *   0  0  8  6 6 0
     *   0  0  0 -2 0 0
     *   0  0  1  2 4 0
     *
     * The 16 hourglass sums are:
     *  -63, -34, -9, 12,
     *  -10,   0, 28, 23,
     *   27, -11, -2, 10,
     *    9,  17, 25, 18
     *
     * The highest hourglass sum is 28 from the hourglass beginning at row 1, column 2:
     *  0 4 3
     *    1
     *  8 6 6
     *
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(final List<List<Integer>> matrix) {
        // Write your code here
        final List<Integer> highestHourglassSums = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                try {
                    highestHourglassSums.add(sumHourglassMatrixValues(getHourglassSubMatrix(matrix, i, j)));
                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Hourglass sub matrix is out of bounds for line " + i + " and column " + j);
                }
            }
        }

        return highestHourglassSums.stream().max(Integer::compareTo).orElse(0);
    }

    private static List<List<Integer>> getHourglassSubMatrix(final List<List<Integer>> matrix,
                                                             final int startRow, final int startCol) {
        validateOutOfBoundsException(matrix, startRow, startCol);

        final List<List<Integer>> hourglassSubMatrix = new ArrayList<>();
        hourglassSubMatrix.add(new ArrayList<>(List.of(1, 1, 1)));
        hourglassSubMatrix.add(new ArrayList<>(List.of(0, 1, 0)));
        hourglassSubMatrix.add(new ArrayList<>(List.of(1, 1, 1)));

        for (int i = 0; i < hourglassSubMatrix.size(); i++) {
            for (int j = 0; j < hourglassSubMatrix.get(i).size(); j++) {
                if (hourglassSubMatrix.get(i).get(j) == 1) {
                    hourglassSubMatrix.get(i).set(j, matrix.get(startRow + i).get(startCol + j));
                }
            }
        }

        return hourglassSubMatrix;
    }

    private static void validateOutOfBoundsException(final List<List<Integer>> matrix,
                                                     final int startRow, final int startCol) {
        final boolean lineOutOfBounds = startRow + 2 > matrix.size() - 1;
        final boolean columnOutOfBounds = startCol + 2 > matrix.get(startRow).size() -1;
        if (lineOutOfBounds || columnOutOfBounds) throw new ArrayIndexOutOfBoundsException();
    }

    private static int sumHourglassMatrixValues(final List<List<Integer>> hourglassMatrix) {
        int hourglassSum = 0;

        for (List<Integer> matrix : hourglassMatrix)
            for (Integer value : matrix) hourglassSum += value;

        return hourglassSum;
    }

    final static class HourglassSumTest {

        @Test
        void shouldReturnHighestNegativeHourglassSumForGivenNonEmptyMatrixTest() {
            // arrange
            final List<List<Integer>> matrix = List.of(
                    List.of(-1, -1,  0, -9, -2, -2),
                    List.of(-2, -1, -6, -8, -2, -5),
                    List.of(-1, -1, -1, -2, -3, -4),
                    List.of(-1, -9, -2, -4, -4, -5),
                    List.of(-7, -3, -3, -2, -9, -9),
                    List.of(-1, -3, -1, -2, -4, -5)
            );
            final int expectedHourglassSum = -6;

            //act
            final int actualHourglassSum = hourglassSum(matrix);

            //assert
            assertEquals(expectedHourglassSum, actualHourglassSum);
        }

        @Test
        void shouldReturnHighestPositiveHourglassSumForGivenNonEmptyMatrixTest() {
            // arrange
            final List<List<Integer>> matrix = List.of(
                    List.of(-9, -9, -9, 1, 1, 1),
                    List.of(0, -9, 0, 4, 3, 2),
                    List.of(-9, -9, -9, 1, 2, 3),
                    List.of(0, 0, 8, 6, 6, 0),
                    List.of(0, 0, 0, -2, 0, 0),
                    List.of(0, 0, 1, 2, 4, 0)
            );
            final int expectedHourglassSum = 28;

            //act
            final int actualHourglassSum = hourglassSum(matrix);

            //assert
            assertEquals(expectedHourglassSum, actualHourglassSum);
        }
    }
}
