package ch.stewue.aoc2022.day1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Part2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("calories top 3: %d %n", getTopThreeCalorie());
    }

    public static int getTopThreeCalorie() throws IOException, URISyntaxException {
        return Utils.getSumByElf()
                .map(i -> -i)
                .sorted() // reverse sort is not possible so stream is inverted before and after the sorting operation
                .map(i -> -i)
                .limit(3)
                .sum();
    }
}
