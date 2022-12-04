package ch.stewue.aoc2022.day1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("the most calories: %d %n", getMaxCalorie());
    }

    public static int getMaxCalorie() throws IOException, URISyntaxException {
        return Utils.getSumByElf()
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
