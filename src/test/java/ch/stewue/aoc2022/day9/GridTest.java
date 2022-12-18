package ch.stewue.aoc2022.day9;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class GridTest {

    @Test
    public void testHeadPositions() throws IOException, URISyntaxException {
        Grid grid = new Grid();
        grid.getMap(Utils.parseInput());
        List<Coordinate> headPositions = grid.getHeadPositions();

        assertThat(headPositions).containsExactly(
                new Coordinate(1, 0),
                new Coordinate(2, 0),
                new Coordinate(3, 0),
                new Coordinate(4, 0),
                new Coordinate(4, 1),
                new Coordinate(4, 2),
                new Coordinate(4, 3),
                new Coordinate(4, 4),
                new Coordinate(3, 4),
                new Coordinate(2, 4),
                new Coordinate(1, 4),
                new Coordinate(1, 3),
                new Coordinate(2, 3),
                new Coordinate(3, 3),
                new Coordinate(4, 3),
                new Coordinate(5, 3),
                new Coordinate(5, 2),
                new Coordinate(4, 2),
                new Coordinate(3, 2),
                new Coordinate(2, 2),
                new Coordinate(1, 2),
                new Coordinate(0, 2),
                new Coordinate(1, 2),
                new Coordinate(2, 2)
        ).inOrder();
    }

    @Test
    public void testTailPositions() throws IOException, URISyntaxException {
        Grid grid = new Grid();
        grid.getMap(Utils.parseInput());
        List<Coordinate> tailPositions = grid.getTailPositions();

        assertThat(tailPositions).containsExactly(
                new Coordinate(0, 0),
                new Coordinate(1, 0),
                new Coordinate(2, 0),
                new Coordinate(3, 0),
                new Coordinate(3, 0),
                new Coordinate(4, 1),
                new Coordinate(4, 2),
                new Coordinate(4, 3),
                new Coordinate(4, 3),
                new Coordinate(3, 4),
                new Coordinate(2, 4),
                new Coordinate(2, 4),
                new Coordinate(2, 4),
                new Coordinate(2, 4),
                new Coordinate(3, 3),
                new Coordinate(4, 3),
                new Coordinate(4, 3),
                new Coordinate(4, 3),
                new Coordinate(4, 3),
                new Coordinate(3, 2),
                new Coordinate(2, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2)
        ).inOrder();
    }
}