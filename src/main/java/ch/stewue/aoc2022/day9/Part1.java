package ch.stewue.aoc2022.day9;

import java.io.IOException;
import java.net.URISyntaxException;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("number of visited: %s %n", numberOfVisited());
    }

    public static long numberOfVisited() throws IOException, URISyntaxException {
        Grid grid = new Grid();
        grid.getMap(Utils.parseInput());
        return grid.getTailCounter().size();
    }
}
