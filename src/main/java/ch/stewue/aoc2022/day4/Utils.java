package ch.stewue.aoc2022.day4;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.BiFunction;

public class Utils {

    public static List<Pair> getPairs() throws IOException, URISyntaxException {
        return FileUtils.getLines(Utils.class, "input.txt")
                .stream()
                .map(l -> l.split(","))
                .map(l -> new Pair(parseInput(l[0]), parseInput(l[1])))
                .toList();
    }

    public static long getNumberOfMatches(BiFunction<Range, Range, Boolean> matchFunction) throws IOException, URISyntaxException {
        return Utils.getPairs()
                .stream()
                .filter(i -> matchFunction.apply(i.first(), i.second()))
                .count();
    }

    private static Range parseInput(String input) {
        String[] parts = input.split("-");
        return new Range(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }


}
