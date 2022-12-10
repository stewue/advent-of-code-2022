package ch.stewue.aoc2022.day8;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static ch.stewue.aoc2022.day8.Utils.*;

public class Forest {

    private final int numberOfRow;
    private final int numberOfColumns;
    private final List<List<Tree>> grid = Lists.newArrayList();

    public Forest(int numberOfRow, int numberOfColumns) {
        this.numberOfRow = numberOfRow;
        this.numberOfColumns = numberOfColumns;
    }

    public void addTreeRow(int rowIndex, List<Tree> treeRow) {
        grid.add(rowIndex, treeRow);
    }

    public List<List<Tree>> getGrid() {
        return grid;
    }

    public Tree getTree(int rowIndex, int columnIndex) {
        return grid.get(rowIndex).get(columnIndex);
    }

    public void computeVisibility() {
        for (int rowIndex = 0; rowIndex < numberOfColumns; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfRow; columnIndex++) {
                int finalRowIndex = rowIndex;
                int finalColumnIndex = columnIndex;
                boolean visible = Arrays.stream(Direction.values())
                        .anyMatch(d -> isTreeVisible(d, finalRowIndex, finalColumnIndex));
                getTree(rowIndex, columnIndex).setVisible(visible);
            }
        }
    }

    @VisibleForTesting
    public boolean isTreeVisible(Direction direction, int rowIndex, int columnIndex) {
        int currentHeight = getTree(rowIndex, columnIndex).getHeight();
        return getHeightList(direction, rowIndex, columnIndex)
                .stream()
                .allMatch(h -> h < currentHeight);
    }

    public void computeScore() {
        for (int rowIndex = 0; rowIndex < numberOfColumns; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfRow; columnIndex++) {
                int finalRowIndex = rowIndex;
                int finalColumnIndex = columnIndex;
                int score = Arrays.stream(Direction.values())
                        .mapToInt(d -> getMultiplier(d, finalRowIndex, finalColumnIndex))
                        .reduce(1, Math::multiplyExact);
                getTree(rowIndex, columnIndex).setScore(score);
            }
        }
    }

    @VisibleForTesting
    public int getMultiplier(Direction direction, int rowIndex, int columnIndex) {
        int currentHeight = getTree(rowIndex, columnIndex).getHeight();
        int multiplier = 0;

        for (Integer h : getHeightList(direction, rowIndex, columnIndex)) {
            multiplier++;
            if (h >= currentHeight) {
                break;
            }
        }

        return multiplier;
    }

    private List<Integer> getHeightList(Direction direction, int rowIndex, int columnIndex) {
        List<Integer> rows = getList(switch (direction) {
            case LEFT -> getConstantStream(rowIndex, columnIndex);
            case RIGHT -> getConstantStream(rowIndex, numberOfColumns - columnIndex - 1);
            case TOP -> reverse(IntStream.range(0, rowIndex));
            case BOTTOM -> IntStream.range(rowIndex + 1, numberOfRow);
        });
        List<Integer> columns = getList(switch (direction) {
            case LEFT -> reverse(IntStream.range(0, columnIndex));
            case RIGHT -> IntStream.range(columnIndex + 1, numberOfColumns);
            case TOP -> getConstantStream(columnIndex, rowIndex);
            case BOTTOM -> getConstantStream(columnIndex, numberOfRow - rowIndex - 1);
        });

        return IntStream.range(0, rows.size())
                .mapToObj(i -> getTree(rows.get(i), columns.get(i)))
                .map(Tree::getHeight)
                .toList();
    }
}
