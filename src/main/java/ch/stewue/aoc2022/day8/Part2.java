package ch.stewue.aoc2022.day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

public class Part2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("heighest score: %s %n", getHighestScore());
    }

    public static int getHighestScore() throws IOException, URISyntaxException {
        Forest forest = Utils.parseGrid();
        forest.computeScore();
        return forest.getGrid()
                .stream()
                .map(row -> row.stream()
                        .map(Tree::getScore)
                        .toList()
                )
                .flatMap(Collection::stream)
                .mapToInt(i -> i)
                .max()
                .orElseThrow();
    }
}
