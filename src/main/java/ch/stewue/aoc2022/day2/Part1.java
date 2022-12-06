package ch.stewue.aoc2022.day2;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        int points = getGames()
                .map(Game::getPoints)
                .mapToInt(i -> i)
                .sum();

        System.out.printf("Total points: %d %n", points);
    }

    public static Stream<Game> getGames() throws URISyntaxException, IOException {
        List<String> lines = FileUtils.getLines(Part1.class, "input.txt");
        return lines.stream()
                .map(l -> l.split(" "))
                .map(c -> new Game(parseChoice(c[0]), parseChoice(c[1])));
    }

    private static Choice parseChoice(String input) {
        return switch (input) {
            case "A", "X" -> Choice.ROCK;
            case "B", "Y" -> Choice.PAPER;
            case "C", "Z" -> Choice.SCISSORS;
            default -> throw new IllegalArgumentException();
        };
    }
}
