package org.kata.tennis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGameTest {

    private static Stream<Arguments> testCalculateScore() {
        return Stream.of(
                Arguments.of("ABABAA", "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Player A wins the game"),
                Arguments.of("ABABABAB", "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Player A : 40 / Player B : 40\n" +
                        "Player A : Deuce / Player B : Deuce")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testCalculateScore(String input, String expectedOutput) {
        TennisGame tennisGame = new TennisGame();
        assertEquals(expectedOutput, tennisGame.calculateScore(input));
    }
}
