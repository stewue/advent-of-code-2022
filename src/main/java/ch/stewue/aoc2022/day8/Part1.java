package ch.stewue.aoc2022.day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("number of visible trees: %s %n", numberOfVisibleTrees());
    }

    public static long numberOfVisibleTrees() throws IOException, URISyntaxException {
        Forest forest = Utils.parseGrid();
        forest.computeVisibility();
        return forest.getGrid()
                .stream()
                .map(row -> row.stream()
                        .map(Tree::getVisible)
                        .toList()
                )
                .flatMap(Collection::stream)
                .filter(b -> b)
                .count();
    }
}
