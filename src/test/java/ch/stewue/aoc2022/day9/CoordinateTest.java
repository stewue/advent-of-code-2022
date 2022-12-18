package ch.stewue.aoc2022.day9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class CoordinateTest {

    @Test(dataProvider = "nextHeadCoordinate")
    public void testNextHeadCoordinate(Coordinate current, Direction direction, Coordinate next) {
        Coordinate nextCoordinate = current.nextHeadCoordinate(direction);
        assertThat(nextCoordinate).isEqualTo(next);
    }

    @DataProvider
    public Object[][] nextHeadCoordinate() {
        return new Object[][]{
                new Object[]{new Coordinate(1, 1), Direction.U, new Coordinate(1, 2)},
                new Object[]{new Coordinate(1, 1), Direction.D, new Coordinate(1, 0)},
                new Object[]{new Coordinate(1, 1), Direction.L, new Coordinate(0, 1)},
                new Object[]{new Coordinate(1, 1), Direction.R, new Coordinate(2, 1)}
        };
    }

    @Test(dataProvider = "isTouching")
    public void testIsTouching(Coordinate tail, Coordinate head, boolean result) {
        boolean isTouching = tail.isTouching(head);
        assertThat(isTouching).isEqualTo(result);
    }

    @DataProvider
    public Object[][] isTouching() {
        return new Object[][]{
                new Object[]{new Coordinate(2, 2), new Coordinate(1, 1), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(2, 1), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(3, 1), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(1, 2), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(2, 2), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(3, 2), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(1, 3), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(2, 3), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(3, 3), true},
                new Object[]{new Coordinate(2, 2), new Coordinate(0, 0), false},
                new Object[]{new Coordinate(2, 2), new Coordinate(0, 2), false},
                new Object[]{new Coordinate(2, 2), new Coordinate(2, 0), false}
        };
    }

    @Test(dataProvider = "nextTailCoordinate")
    public void testNextTailCoordinate(Coordinate currentTail, Coordinate head, Coordinate nextTail) {
        Coordinate nextCoordinate = currentTail.nextTailCoordinate(head);
        assertThat(nextCoordinate).isEqualTo(nextTail);
    }

    @DataProvider
    public Object[][] nextTailCoordinate() {
        return new Object[][]{
                new Object[]{new Coordinate(1, 1), new Coordinate(2, 1), new Coordinate(1, 1)},
                new Object[]{new Coordinate(1, 1), new Coordinate(2, 3), new Coordinate(2, 2)},
                new Object[]{new Coordinate(1, 1), new Coordinate(3, 2), new Coordinate(2, 2)},
                new Object[]{new Coordinate(3, 0), new Coordinate(4, 1), new Coordinate(3, 0)}
        };
    }
}