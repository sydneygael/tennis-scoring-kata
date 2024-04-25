package org.kata.tennis;

/**
 * Classe pour respecter le principe de la single responsability
 */

public class ScorePrinter {
    private final StringBuilder result = new StringBuilder();
    private boolean isDuced = false;

    public void update(Score score) {
        if (score.isSomeoneAdvantaged()) {
            result.append(String.format("Player %s wins the game\n", score.getPlayerWithHighestScore()));
        }

        if (!isDuced) {
            if (score.checkDeuceCondition()) {
                lineScore(score);
                result.append("Player A : Deuce / Player B : Deuce\n");
                isDuced = true;
            } else if (score.isPlayerAWinner()) {
                result.append("Player A wins the game\n");
            } else if (score.isPlayerBWinner()) {
                result.append("Player B wins the game\n");
            } else {
                lineScore(score);
            }
        }

    }

    public String getResult() {
        return result.toString().trim();
    }

    private void lineScore(Score score) {
        result.append("Player A : ").append(formatScore(score.playerAScore()))
                .append(" / Player B : ").append(formatScore(score.playerBScore())).append("\n");
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

