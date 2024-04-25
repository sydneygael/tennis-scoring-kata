package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {
        var printer = new ConsoleScorePrinter();
        var score = new Score(0, 0);

        for (char c : input.toCharArray()) {

            // Java 17
            switch (c) {
                case 'A' -> score = score.incrementPlayerAScore();
                case 'B' -> score = score.incrementPlayerBScore();
                default -> throw new IllegalArgumentException("Only A & B are permitted");
            }

            if (score.isSomeoneWinner() || score.isSomeoneAdvantaged()) {
                printer.update(score);
                break;
            } else {
                printer.update(score);
            }
        }

        return printer.getResult();
    }
}

