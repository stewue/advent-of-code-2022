package ch.stewue.aoc2022.day9;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;

public record Coordinate(int x, int y) {

    public Coordinate nextHeadCoordinate(Direction direction) {
        return new Coordinate(x + direction.getxChange(), y + direction.getyChange());
    }

    public Coordinate nextTailCoordinate(Coordinate headCoordinate) {
        if (equals(headCoordinate)) {
            return this;
        }

        if (Math.abs(headCoordinate.x - x) + Math.abs(headCoordinate.y - y) == 1) {
            return this;
        }

        if (isTouching(headCoordinate)) {
            return this;
        }

        int moveX = Ints.constrainToRange(headCoordinate.x - x, -1, 1);
        int moveY = Ints.constrainToRange(headCoordinate.y - y, -1, 1);

        return new Coordinate(x + moveX, y + moveY);
    }

    @VisibleForTesting
    public boolean isTouching(Coordinate otherCoordinate) {
        return Math.abs(x - otherCoordinate.x) <= 1 && Math.abs(y - otherCoordinate.y) <= 1;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
