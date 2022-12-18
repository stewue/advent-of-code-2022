package ch.stewue.aoc2022.day9;

public enum Direction {
    R(1, 0),
    U(0, 1),
    L(-1, 0),
    D(0, -1);

    private final int xChange;
    private final int yChange;

    Direction(int xChange, int yChange) {
        this.xChange = xChange;
        this.yChange = yChange;
    }

    public int getxChange() {
        return xChange;
    }

    public int getyChange() {
        return yChange;
    }
}
