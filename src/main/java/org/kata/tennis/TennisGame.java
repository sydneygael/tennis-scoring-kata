package org.kata.tennis;

public class TennisGame {
    public String calculateScore(String input) {
        StringBuilder result = new StringBuilder();
        int playerAScore = 0;
        int playerBScore = 0;

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                playerAScore++;
            } else if (c == 'B') {
                playerBScore++;
            }

            if (checkWinningCondition(playerAScore, playerBScore)) {
                result.append("Player A wins the game\n");
                break;
            } else if (checkWinningCondition(playerBScore, playerAScore)) {
                result.append("Player B wins the game\n");
                break;
            } else if (checkDeuceCondition(playerAScore, playerBScore)) {
                result.append("Player A : Deuce / Player B : Deuce\n");
            } else {
                result.append("Player A : ").append(formatScore(playerAScore))
                        .append(" / Player B : ").append(formatScore(playerBScore)).append("\n");
            }
        }

        return result.toString().trim();
    }

    /**
     * vérifie si un joueur a gagné la partie en se basant sur ses points par rapport à ceux de son adversaire.
     * @param playerScore
     * @param opponentScore
     * @return true si le score du joueur est d'au moins 4 points (ce qui signifie qu'il a au moins atteint 40)
     *  et s'il a au moins deux points de plus que son adversaire
     */
    private boolean checkWinningCondition(int playerScore, int opponentScore) {
        return playerScore >= 4 && playerScore - opponentScore >= 2;
    }

    /**
     * vérifie si les deux joueurs sont à égalité (c'est-à-dire qu'ils ont tous deux marqué au moins 3 points)
     * et que leurs scores sont identiques
     * @param playerAScore
     * @param playerBScore
     * @return
     */
    private boolean checkDeuceCondition(int playerAScore, int playerBScore) {
        return playerBScore >= 3 && playerAScore == playerBScore;
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

