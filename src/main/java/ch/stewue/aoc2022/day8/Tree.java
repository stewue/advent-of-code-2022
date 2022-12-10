package ch.stewue.aoc2022.day8;

public class Tree {

    private final int height;
    private Boolean visible = null;
    private Integer score = null;

    public Tree(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                ", visible=" + visible +
                ", score=" + score +
                '}';
    }
}
