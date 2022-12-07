package ch.stewue.aoc2022.day3;

import ch.stewue.aoc2022.utils.FileUtils;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("sum: %d %n", getSum());
    }

    public static int getSum() throws IOException, URISyntaxException {
        return getCompartments()
                .stream()
                .map(Utils::getDuplicateCharacter)
                .map(Utils::getPriority)
                .mapToInt(i -> i)
                .sum();
    }

    public static List<List<String>> getCompartments() throws IOException, URISyntaxException {
        List<String> lines = FileUtils.getLines(Utils.class, "input.txt");

        return Lists.partition(lines, 3);
    }
}
