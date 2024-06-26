package org.kata.tennis;

public record Score(int playerAScore, int playerBScore) {

    /**
     * constructeur canonique
     */

    public Score {
        if (playerAScore < 0 || playerBScore < 0) {
            throw new IllegalArgumentException("Scores cannot be negative");
        }
    }

    public Score incrementPlayerAScore() {
        return new Score(playerAScore + 1, playerBScore);
    }

    public Score incrementPlayerBScore() {
        return new Score(playerAScore, playerBScore + 1);
    }

    public boolean isPlayerAWinner() {
        return playerAScore >= 4 && playerAScore - playerBScore >= 2;
    }

    public boolean isPlayerBWinner() {
        return playerBScore >= 4 && playerBScore - playerAScore >= 2;
    }

    /**
     * vérifie si les deux joueurs sont à égalité (c'est-à-dire qu'ils ont tous deux marqué au moins 3 points)
     * et que leurs scores sont identiques
     */
    public boolean checkDeuceCondition() {
        return playerAScore >= 3 && playerAScore == playerBScore;
    }

    public boolean isPlayerAAdvantaged() {
        return (playerAScore >= 4 && playerBScore >= 4 && playerAScore == playerBScore + 1);
    }

    public boolean isPlayerBAdvantaged() {
        return (playerAScore >= 4 && playerBScore >= 4 && playerBScore == playerAScore + 1);
    }

    public boolean isSomeoneWinner() {
        return isPlayerAWinner() || isPlayerBWinner();
    }

    public boolean isSomeoneAdvantaged() {
        return isPlayerAAdvantaged() || isPlayerBAdvantaged();
    }

    public String getPlayerWithHighestScore() {
        return (playerAScore > playerBScore) ? "A" : "B";
    }
}

