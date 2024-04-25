package org.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class TennisGameTest {

    @Test
    void shouldCalculateScore(){
        assertEquals("",new TennisGame().calculateScore("ABABAA"));
    }
  
}