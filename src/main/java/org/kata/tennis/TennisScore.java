package org.kata.tennis;

public enum TennisScore {
    LOVE(0, "0"),
    FIFTEEN(1, "15"),
    THIRTY(2, "30"),
    FORTY(3, "40");

    private final int value;
    private final String display;

    TennisScore(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public static TennisScore fromValue(int value) {
        for (TennisScore score : TennisScore.values()) {
            if (score.value == value) {
                return score;
            }
        }
        throw new IllegalArgumentException("Invalid score value");
    }
}
