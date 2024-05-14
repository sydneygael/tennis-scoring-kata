package org.kata.tennis;

import java.text.MessageFormat;

public class SimpleScoreFormatter implements ScoreFormatter {
    private final ScoreRepository scoreRepository;

    public SimpleScoreFormatter(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public String formatScore(Score score) {
        boolean alreadyDeuce = scoreRepository.getScoreHistory().stream().anyMatch(line -> line.contains(ScoreRepository.DEUCE));

        if (score.checkDeuceCondition() && !alreadyDeuce) {
            return ScoreRepository.DEUCE;
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