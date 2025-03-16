package org.exercises.intermediate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArray {

    /*
     * Function Description
     *
     * Complete the 'dynamicArray' function with the following parameters:
     * - int n: the number of empty arrays to initialize in arr
     * - int queries[q][3]: 2-D array of integers
     *
     * Returns
     * int[]: the results of each type 2 query in the order they are presented
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    private static final int QUERY_TYPE_ONE = 1;

    private static final int QUERY_TYPE_TWO = 2;

    public static List<Integer> dynamicArray(final int n, final List<List<Integer>> queries) {
        // Write your code here
        int lastAnswer = 0;
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (final List<Integer> query : queries) {
            int x = query.get(1); int y = query.get(2);
            int queryType = query.get(0); int idx = (x ^ lastAnswer) % n;

            if (queryType == QUERY_TYPE_ONE) {
                arr.get(idx).add(y);
            } else if (queryType == QUERY_TYPE_TWO){
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }

        return answers;
    }

    static class DynamicArrayTest {

        @Test
        void shouldReturnExpectedAnswersForGivenQueriesTest() {
            final List<List<Integer>> queries = List.of(
                    List.of(1, 0, 5),
                    List.of(1, 1, 7),
                    List.of(1, 0, 3),
                    List.of(2, 1, 0),
                    List.of(2, 1, 1)
            );
            final String expectedAnswers = "[7, 3]";

            final List<Integer> actualAnswers = dynamicArray(2, queries);

            assertEquals(expectedAnswers, actualAnswers.toString());
        }
    }

    @Test
    void shouldReturnExpectedEmptyAnswersForGivenEmptyQueriesTest() {
        final List<List<Integer>> queries = List.of();
        final String expectedAnswers = "[]";

        final List<Integer> actualAnswers = dynamicArray(2, queries);

        assertEquals(expectedAnswers, actualAnswers.toString());
    }
}
