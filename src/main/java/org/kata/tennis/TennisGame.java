package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {
        var result = new StringBuilder();
        var score = new Score(0, 0);

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                score = score.incrementPlayerAScore();
            } else if (c == 'B') {
                score = score.incrementPlayerBScore();
            }

            if (score.isPlayerAWinner()) {
                result.append("Player A wins the game\n");
                break;
            } else if (score.isPlayerBWinner()) {
                result.append("Player B wins the game\n");
                break;
            } else if (score.checkDeuceCondition()) {
                lineScore(result, score.playerAScore(), score.playerBScore());
                result.append("Player A : Deuce / Player B : Deuce\n");
                break;
            } else {
                lineScore(result, score.playerAScore(), score.playerBScore());
            }
        }

        return result.toString().trim();
    }

    private void lineScore(StringBuilder result, int playerAScore, int playerBScore) {
        result.append("Player A : ").append(formatScore(playerAScore))
                .append(" / Player B : ").append(formatScore(playerBScore)).append("\n");
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

