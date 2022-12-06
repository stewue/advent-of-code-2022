package ch.stewue.aoc2022.day2;

import java.util.Arrays;

public enum Choice {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int points;

    Choice(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public boolean loseAgainst(Choice opponent) {
        return opponent.winAgainst(this);
    }

    public boolean drawAgainst(Choice opponent) {
        return this.equals(opponent);
    }

    public boolean winAgainst(Choice opponent) {
        return this.getPoints() - opponent.getPoints() % 3 == 1;
    }

    public Choice loseChoice() {
        return Arrays.stream(Choice.values())
                .filter(me -> me.loseAgainst(this))
                .findFirst()
                .orElseThrow();
    }

    public Choice winChoice() {
        return Arrays.stream(Choice.values())
                .filter(me -> me.winAgainst(this))
                .findFirst()
                .orElseThrow();
    }
}
