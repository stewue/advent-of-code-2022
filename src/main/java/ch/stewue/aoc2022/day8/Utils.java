package ch.stewue.aoc2022.day8;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {

    public static Forest parseGrid() throws IOException, URISyntaxException {
        List<String> lines = FileUtils.getLines(Utils.class, "input.txt");
        Forest forest = new Forest(lines.size(), lines.get(0).length());

        for (int i = 0; i < lines.size(); i++) {
            List<Tree> treeRow = lines.get(i)
                    .chars()
                    .mapToObj(c -> (char) c)
                    .map(Character::getNumericValue)
                    .map(Tree::new)
                    .toList();
            forest.addTreeRow(i, treeRow);
        }
        return forest;
    }

    public static IntStream reverse(IntStream stream) {
        return stream.boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i);
    }

    public static IntStream getConstantStream(int value, int size) {
        return IntStream.generate(() -> value)
                .limit(size);
    }

    public static List<Integer> getList(IntStream stream) {
        return stream.boxed()
                .toList();
    }
}
