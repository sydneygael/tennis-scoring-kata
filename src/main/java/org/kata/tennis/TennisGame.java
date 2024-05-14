package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {

        var scoreRepository = new ScoreRepository();
        var printer = new ConsoleScorePrinter(scoreRepository);
        var score = new Score(0, 0);

        for (char c : input.toCharArray()) {

            // Java 17
            switch (c) {
                case 'A' -> score = score.incrementPlayerAScore();
                case 'B' -> score = score.incrementPlayerBScore();
                default -> throw new IllegalArgumentException("Only A & B are permitted");
            }

            scoreRepository.updateScore(score);

            if (score.isSomeoneWinner() || score.isSomeoneAdvantaged()) {
                break;
            }
        }

        return printer.printScoreHistory();
    }
}

