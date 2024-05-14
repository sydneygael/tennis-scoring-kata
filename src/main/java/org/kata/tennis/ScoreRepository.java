package org.kata.tennis;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ScoreRepository {
    public static final String DEUCE = "Deuce!";
    private final List<String> scoreHistory;

    public ScoreRepository() {
        this.scoreHistory = new ArrayList<>();
    }

    public List<String> getScoreHistory() {
        return scoreHistory;
    }

    public void updateScore(Score score) {
        var formattedScore = formatScore(score);
        if (!formattedScore.isEmpty()) {
            scoreHistory.add(formattedScore);
        }
    }

    private String formatScore(Score score) {
        boolean alreadyDeuce = scoreHistory.stream().anyMatch(line -> line.contains(DEUCE));

        if (score.checkDeuceCondition() && !alreadyDeuce) {
            return DEUCE;
        }

        if (score.isSomeoneAdvantaged() || score.isSomeoneWinner()) {
            return MessageFormat.format("Player {0} wins the game", score.getPlayerWithHighestScore());
        }

        if (alreadyDeuce && !score.isSomeoneWinner()) {
            return "";
        }

        return MessageFormat.format("Player A : {0} / Player B : {1}",
                formatPlayerScore(score.playerAScore()), formatPlayerScore(score.playerBScore()));
    }

    private String formatPlayerScore(int score) {
        return TennisScore.fromValue(score).getDisplay();
    }
}

