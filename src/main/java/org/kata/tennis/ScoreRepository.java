package org.kata.tennis;

import java.util.ArrayList;
import java.util.List;

public class ScoreRepository {
    public static final String DEUCE = "Deuce!";
    private final List<String> scoreHistory;
    private final ScoreFormatter scoreFormatter = new SimpleScoreFormatter(this);

    public ScoreRepository() {
        this.scoreHistory = new ArrayList<>();
    }

    public List<String> getScoreHistory() {
        return scoreHistory;
    }

    public void updateScore(Score score) {
        var formattedScore = scoreFormatter.formatScore(score);
        if (!formattedScore.isEmpty()) {
            scoreHistory.add(formattedScore);
        }
    }

}

