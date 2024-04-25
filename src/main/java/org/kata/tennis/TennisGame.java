package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {
        var printer = new ScorePrinter();
        var score = new Score(0, 0);

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                score = score.incrementPlayerAScore();
            } else if (c == 'B') {
                score = score.incrementPlayerBScore();
            }

            if (isGameFinished(score)) {
                printer.update(score);
                break;
            } else {
                printer.update(score);
            }
        }

        return printer.getResult();
    }

    private boolean isGameFinished(Score score) {
        return score.isPlayerAWinner() || score.isPlayerBWinner() || score.checkDeuceCondition();
    }

    private String formatScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "";
        };
    }
}

