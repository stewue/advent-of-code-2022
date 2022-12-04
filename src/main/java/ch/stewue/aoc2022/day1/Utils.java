package ch.stewue.aoc2022.day1;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static IntStream getSumByElf() throws IOException, URISyntaxException {
        List<String> lines = FileUtils.getLines(Utils.class, "input.txt");
        String[] caloriesByElf = String.join("\n", lines).split("\n\n");

        return Arrays.stream(caloriesByElf)
                .map(Utils::sumCalories)
                .mapToInt(i -> i);
    }

    private static int sumCalories(String calorieString) {
        return Arrays.stream(calorieString.split("\n"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
