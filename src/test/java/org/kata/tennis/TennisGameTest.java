package org.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGameTest {

    @Test
    void shouldCalculateScore() {
        assertEquals("Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Player A wins the game",
                new TennisGame().calculateScore("ABABAA"));
    }

}