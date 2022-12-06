package ch.stewue.aoc2022.day2;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

public class Part2 {
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
                .map(c -> parseGame(c[0], c[1]));
    }

    private static Game parseGame(String inputOpponent, String inputOutcome) {
        Choice opponent = parseOpponent(inputOpponent);
        Choice me = switch (inputOutcome) {
            case "X" -> opponent.loseChoice();
            case "Y" -> opponent;
            case "Z" -> opponent.winChoice();
            default -> throw new IllegalArgumentException();
        };

        return new Game(opponent, me);
    }

    private static Choice parseOpponent(String input) {
        return switch (input) {
            case "A" -> Choice.ROCK;
            case "B" -> Choice.PAPER;
            case "C" -> Choice.SCISSORS;
            default -> throw new IllegalArgumentException();
        };
    }
}
