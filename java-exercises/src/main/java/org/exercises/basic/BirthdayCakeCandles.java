package org.exercises.basic;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final public class BirthdayCakeCandles {

    private static final Map<Integer, Integer> highestCandles = new HashMap<>();

    /*
     * You are in charge of the cake for a child's birthday.
     * It will have one candle for each year of their total age.
     * They will only be able to blow out the tallest of the candles.
     * Your task is to count how many candles are the tallest.
     *
     * Example
     *
     * candles = [4, 4, 1, 3]
     *
     * The tallest candles are 4 units high.
     * There are 2 candles with this height, so the function should return 2.
     *
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */
    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Integer highestCandle = 0;

        for (Integer candle : candles) {
            if (candle >= highestCandle) {
                highestCandle = candle;
                updateCandlesMap(candle);
            }
        }

        return Optional.ofNullable(highestCandles.get(highestCandle)).orElse(0);
    }

    private static void updateCandlesMap(final Integer candle) {
        if (highestCandles.containsKey(candle)) {
            highestCandles.put(candle, highestCandles.get(candle) + 1);
        } else {
            highestCandles.put(candle, 1);
        }
    }

    final static class BirthdayCakeCandlesTest {

        @Test
        void shouldReturnExpectedNumberOfHighestCandlesForGivenNonEmptyArrayOfCandlesTest() {
            // arrange
            final List<Integer> candles = List.of(3, 2, 1, 3);
            final int expectedNumberOfHighestCandles = 2; // 3, 3

            // act
            final int actualNumberOfHighestCandles = birthdayCakeCandles(candles);

            // assert
            assertEquals(expectedNumberOfHighestCandles, actualNumberOfHighestCandles);
        }

        @Test
        void shouldReturnZeroHighestCandlesForGivenEmptyArrayOfCandlesTest() {
            // arrange
            final List<Integer> candles = Collections.emptyList();
            final int expectedNumberOfHighestCandles = 0;

            // act
            final int actualNumberOfHighestCandles = birthdayCakeCandles(candles);

            // assert
            assertEquals(expectedNumberOfHighestCandles, actualNumberOfHighestCandles);
        }
    }
}
