package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {
        var result = new ScorePrinter();
        var score = new Score(0, 0);

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                score = score.incrementPlayerAScore();
            } else if (c == 'B') {
                score = score.incrementPlayerBScore();
            }

            if (isGameFinished(score)) {
                result.update(score);
                break;
            } else {
                result.update(score);
            }
        }

        return result.getResult();
    }

    private static boolean isGameFinished(Score score) {
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

