package org.kata.tennis;

/**
 * Classe pour respecter le principe de la single responsability
 */

public class ConsoleScorePrinter implements ScorePrinter {

    private final ScoreRepository scoreRepository;

    public ConsoleScorePrinter(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public String printScoreHistory() {
        return String.join("\n", scoreRepository.getScoreHistory());
    }
}

