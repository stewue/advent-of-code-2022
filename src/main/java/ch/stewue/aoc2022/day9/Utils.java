package ch.stewue.aoc2022.day9;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Utils {

    public static List<Motion> parseInput() throws IOException, URISyntaxException {
        return FileUtils.getLines(Utils.class, "input.txt")
                .stream()
                .map(l -> {
                    String[] parts = l.split(" ");
                    return new Motion(Direction.valueOf(parts[0]), Integer.parseInt(parts[1]));
                })
                .toList();
    }
}
