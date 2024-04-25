package org.kata.tennis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TennisGameTest {

    /**
     *  On test :
     *  CAS 1 : ABABAA -> Joueur 1 gagne
     *  CAS 2 : Deuce
     *  CAS 3 : Joueur 3 gagne avec un Deuce
     * @return
     */

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
                        "Player A : Deuce / Player B : Deuce"),
                Arguments.of("ABABABABB", "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Player A : 40 / Player B : 40\n" +
                        "Player A : Deuce / Player B : Deuce\n"+
                        "Player B wins the game")

        );
    }

    @ParameterizedTest
    @MethodSource
    void testCalculateScore(String input, String expectedOutput) {
        var tennisGame = new TennisGame();
        assertEquals(expectedOutput, tennisGame.calculateScore(input));
    }

    @Test
    void calculateScore_WithInvalidInput_ShouldThrowIllegalArgumentException() {
        var tennisGame = new TennisGame();
        assertThrows(IllegalArgumentException.class, () -> tennisGame.calculateScore("ABCDE"));
    }
}
