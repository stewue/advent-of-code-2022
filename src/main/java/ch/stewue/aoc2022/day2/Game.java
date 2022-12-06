package ch.stewue.aoc2022.day2;

import java.util.Objects;

public class Game {
    private final static int POINTS_DRAW = 3;
    private final static int POINTS_WON = 6;

    private final Choice opponent;
    private final Choice me;

    public Game(Choice opponent, Choice me) {
        this.opponent = opponent;
        this.me = me;
    }

    public int getPoints() {
        int points = me.getPoints();
        if (me.drawAgainst(opponent)) {
            points += POINTS_DRAW;
        } else if (me.winAgainst(opponent)) {
            points += POINTS_WON;
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return opponent == game.opponent && me == game.me;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opponent, me);
    }
}