package ch.stewue.aoc2022.day2;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {
    @Test
    public void testGetGames() throws IOException, URISyntaxException {
        List<Game> games = Part1.getGames()
                .toList();

        assertThat(games).containsExactly(
                new Game(Choice.ROCK, Choice.PAPER),
                new Game(Choice.PAPER, Choice.ROCK),
                new Game(Choice.SCISSORS, Choice.SCISSORS)
        ).inOrder();
    }
}
