package ch.stewue.aoc2022.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class GameTest {

    @Test(dataProvider = "game")
    public void testPoints(Choice me, Choice opponent, int points) {
        Game game = new Game(opponent, me);
        assertThat(game.getPoints()).isEqualTo(points);
    }

    @DataProvider
    public Object[][] game() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.ROCK, 4},
                new Object[]{Choice.ROCK, Choice.PAPER, 1},
                new Object[]{Choice.ROCK, Choice.SCISSORS, 7},
                new Object[]{Choice.PAPER, Choice.ROCK, 8},
                new Object[]{Choice.PAPER, Choice.PAPER, 5},
                new Object[]{Choice.PAPER, Choice.SCISSORS, 2},
                new Object[]{Choice.SCISSORS, Choice.ROCK, 3},
                new Object[]{Choice.SCISSORS, Choice.PAPER, 9},
                new Object[]{Choice.SCISSORS, Choice.SCISSORS, 6}
        };
    }
}
