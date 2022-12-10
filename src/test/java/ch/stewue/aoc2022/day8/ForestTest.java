package ch.stewue.aoc2022.day8;

import com.google.common.collect.Lists;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ForestTest {

    private static final List<List<Integer>> HEIGHT = Lists.newArrayList(
            Lists.newArrayList(3, 0, 3, 7, 3),
            Lists.newArrayList(2, 5, 5, 1, 2),
            Lists.newArrayList(6, 5, 3, 3, 2),
            Lists.newArrayList(3, 3, 5, 4, 9),
            Lists.newArrayList(3, 5, 3, 9, 0)
    );

    @Test(dataProvider = "leftVisible")
    public void testLeftVisible(int rowIndex, int columnIndex, boolean visible) {
        Forest forest = getForest();
        assertThat(forest.isTreeVisible(Direction.LEFT, rowIndex, columnIndex)).isEqualTo(visible);
    }

    @DataProvider
    public Object[][] leftVisible() {
        return new Object[][]{
                new Object[]{0, 0, true},
                new Object[]{0, 1, false},
                new Object[]{0, 2, false},
                new Object[]{0, 3, true},
                new Object[]{0, 4, false},
                new Object[]{1, 0, true},
                new Object[]{1, 1, true},
                new Object[]{1, 2, false},
                new Object[]{1, 3, false},
                new Object[]{1, 4, false},
                new Object[]{2, 0, true},
                new Object[]{2, 1, false},
                new Object[]{2, 2, false},
                new Object[]{2, 3, false},
                new Object[]{2, 4, false},
                new Object[]{3, 0, true},
                new Object[]{3, 1, false},
                new Object[]{3, 2, true},
                new Object[]{3, 3, false},
                new Object[]{3, 4, true},
                new Object[]{4, 0, true},
                new Object[]{4, 1, true},
                new Object[]{4, 2, false},
                new Object[]{4, 3, true},
                new Object[]{4, 4, false}
        };
    }

    @Test(dataProvider = "rightVisible")
    public void testRightVisible(int rowIndex, int columnIndex, boolean visible) {
        Forest forest = getForest();
        assertThat(forest.isTreeVisible(Direction.RIGHT, rowIndex, columnIndex)).isEqualTo(visible);
    }

    @DataProvider
    public Object[][] rightVisible() {
        return new Object[][]{
                new Object[]{0, 0, false},
                new Object[]{0, 1, false},
                new Object[]{0, 2, false},
                new Object[]{0, 3, true},
                new Object[]{0, 4, true},
                new Object[]{1, 0, false},
                new Object[]{1, 1, false},
                new Object[]{1, 2, true},
                new Object[]{1, 3, false},
                new Object[]{1, 4, true},
                new Object[]{2, 0, true},
                new Object[]{2, 1, true},
                new Object[]{2, 2, false},
                new Object[]{2, 3, true},
                new Object[]{2, 4, true},
                new Object[]{3, 0, false},
                new Object[]{3, 1, false},
                new Object[]{3, 2, false},
                new Object[]{3, 3, false},
                new Object[]{3, 4, true},
                new Object[]{4, 0, false},
                new Object[]{4, 1, false},
                new Object[]{4, 2, false},
                new Object[]{4, 3, true},
                new Object[]{4, 4, true}
        };
    }

    @Test(dataProvider = "topVisible")
    public void testTopVisible(int rowIndex, int columnIndex, boolean visible) {
        Forest forest = getForest();
        assertThat(forest.isTreeVisible(Direction.TOP, rowIndex, columnIndex)).isEqualTo(visible);
    }

    @DataProvider
    public Object[][] topVisible() {
        return new Object[][]{
                new Object[]{0, 0, true},
                new Object[]{0, 1, true},
                new Object[]{0, 2, true},
                new Object[]{0, 3, true},
                new Object[]{0, 4, true},
                new Object[]{1, 0, false},
                new Object[]{1, 1, true},
                new Object[]{1, 2, true},
                new Object[]{1, 3, false},
                new Object[]{1, 4, false},
                new Object[]{2, 0, true},
                new Object[]{2, 1, false},
                new Object[]{2, 2, false},
                new Object[]{2, 3, false},
                new Object[]{2, 4, false},
                new Object[]{3, 0, false},
                new Object[]{3, 1, false},
                new Object[]{3, 2, false},
                new Object[]{3, 3, false},
                new Object[]{3, 4, true},
                new Object[]{4, 0, false},
                new Object[]{4, 1, false},
                new Object[]{4, 2, false},
                new Object[]{4, 3, true},
                new Object[]{4, 4, false}
        };
    }

    @Test(dataProvider = "bottomVisible")
    public void testBottomVisible(int rowIndex, int columnIndex, boolean visible) {
        Forest forest = getForest();
        assertThat(forest.isTreeVisible(Direction.BOTTOM, rowIndex, columnIndex)).isEqualTo(visible);
    }

    @DataProvider
    public Object[][] bottomVisible() {
        return new Object[][]{
                new Object[]{0, 0, false},
                new Object[]{0, 1, false},
                new Object[]{0, 2, false},
                new Object[]{0, 3, false},
                new Object[]{0, 4, false},
                new Object[]{1, 0, false},
                new Object[]{1, 1, false},
                new Object[]{1, 2, false},
                new Object[]{1, 3, false},
                new Object[]{1, 4, false},
                new Object[]{2, 0, true},
                new Object[]{2, 1, false},
                new Object[]{2, 2, false},
                new Object[]{2, 3, false},
                new Object[]{2, 4, false},
                new Object[]{3, 0, false},
                new Object[]{3, 1, false},
                new Object[]{3, 2, true},
                new Object[]{3, 3, false},
                new Object[]{3, 4, true},
                new Object[]{4, 0, true},
                new Object[]{4, 1, true},
                new Object[]{4, 2, true},
                new Object[]{4, 3, true},
                new Object[]{4, 4, true}
        };
    }

    @Test(dataProvider = "score")
    public void testScore(int rowIndex, int columnIndex, int score, int topMultiplier, int leftMultiplier, int rightMultiplier, int bottomMultiplier) {
        Forest forest = getForest();
        forest.computeScore();

        assertThat(forest.getTree(rowIndex, columnIndex).getScore()).isEqualTo(score);
        assertThat(forest.getMultiplier(Direction.TOP, rowIndex, columnIndex)).isEqualTo(topMultiplier);
        assertThat(forest.getMultiplier(Direction.LEFT, rowIndex, columnIndex)).isEqualTo(leftMultiplier);
        assertThat(forest.getMultiplier(Direction.RIGHT, rowIndex, columnIndex)).isEqualTo(rightMultiplier);
        assertThat(forest.getMultiplier(Direction.BOTTOM, rowIndex, columnIndex)).isEqualTo(bottomMultiplier);
    }

    @DataProvider
    public Object[][] score() {
        return new Object[][]{
                new Object[]{1, 2, 4, 1, 1, 2, 2},
                new Object[]{3, 2, 8, 2, 2, 2, 1}
        };
    }

    private Forest getForest() {
        Forest forest = new Forest(5, 5);

        for (int rowIndex = 0; rowIndex < HEIGHT.size(); rowIndex++) {
            List<Tree> treeRow = HEIGHT.get(rowIndex)
                    .stream()
                    .map(Tree::new)
                    .toList();
            forest.addTreeRow(rowIndex, treeRow);
        }

        return forest;
    }

}