package ch.stewue.aoc2022.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChoiceTest {

    @Test(dataProvider = "lose")
    public void testLose(Choice me, Choice opponent, boolean result) {
        assertThat(me.loseAgainst(opponent)).isEqualTo(result);
    }

    @DataProvider
    public Object[][] lose() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.ROCK, false},
                new Object[]{Choice.ROCK, Choice.PAPER, true},
                new Object[]{Choice.ROCK, Choice.SCISSORS, false},
                new Object[]{Choice.PAPER, Choice.ROCK, false},
                new Object[]{Choice.PAPER, Choice.PAPER, false},
                new Object[]{Choice.PAPER, Choice.SCISSORS, true},
                new Object[]{Choice.SCISSORS, Choice.ROCK, true},
                new Object[]{Choice.SCISSORS, Choice.PAPER, false},
                new Object[]{Choice.SCISSORS, Choice.SCISSORS, false}
        };
    }

    @Test(dataProvider = "draw")
    public void testDraw(Choice me, Choice opponent, boolean result) {
        assertThat(me.drawAgainst(opponent)).isEqualTo(result);
    }

    @DataProvider
    public Object[][] draw() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.ROCK, true},
                new Object[]{Choice.ROCK, Choice.PAPER, false},
                new Object[]{Choice.ROCK, Choice.SCISSORS, false},
                new Object[]{Choice.PAPER, Choice.ROCK, false},
                new Object[]{Choice.PAPER, Choice.PAPER, true},
                new Object[]{Choice.PAPER, Choice.SCISSORS, false},
                new Object[]{Choice.SCISSORS, Choice.ROCK, false},
                new Object[]{Choice.SCISSORS, Choice.PAPER, false},
                new Object[]{Choice.SCISSORS, Choice.SCISSORS, true}
        };
    }

    @Test(dataProvider = "win")
    public void testWin(Choice me, Choice opponent, boolean result) {
        assertThat(me.winAgainst(opponent)).isEqualTo(result);
    }

    @DataProvider
    public Object[][] win() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.ROCK, false},
                new Object[]{Choice.ROCK, Choice.PAPER, false},
                new Object[]{Choice.ROCK, Choice.SCISSORS, true},
                new Object[]{Choice.PAPER, Choice.ROCK, true},
                new Object[]{Choice.PAPER, Choice.PAPER, false},
                new Object[]{Choice.PAPER, Choice.SCISSORS, false},
                new Object[]{Choice.SCISSORS, Choice.ROCK, false},
                new Object[]{Choice.SCISSORS, Choice.PAPER, true},
                new Object[]{Choice.SCISSORS, Choice.SCISSORS, false}
        };
    }

    @Test(dataProvider = "loseChoice")
    public void testLoseChoice(Choice opponent, Choice me) {
        assertThat(opponent.loseChoice()).isEqualTo(me);
    }

    @DataProvider
    public Object[][] loseChoice() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.SCISSORS},
                new Object[]{Choice.PAPER, Choice.ROCK},
                new Object[]{Choice.SCISSORS, Choice.PAPER}
        };
    }

    @Test(dataProvider = "winChoice")
    public void testWinChoice(Choice opponent, Choice me) {
        assertThat(opponent.winChoice()).isEqualTo(me);
    }

    @DataProvider
    public Object[][] winChoice() {
        return new Object[][]{
                new Object[]{Choice.ROCK, Choice.PAPER},
                new Object[]{Choice.PAPER, Choice.SCISSORS},
                new Object[]{Choice.SCISSORS, Choice.ROCK}
        };
    }
}
