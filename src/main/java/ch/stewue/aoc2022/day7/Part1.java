package ch.stewue.aoc2022.day7;

import ch.stewue.aoc2022.day7.filesystem.Directory;
import ch.stewue.aoc2022.day7.filesystem.Terminal;
import ch.stewue.aoc2022.day7.parser.Parser;
import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("total size: %d %n", getTotalSize());
    }

    public static int getTotalSize() throws IOException, URISyntaxException {
        Parser parser = new Parser();
        List<String> lines = FileUtils.getLines(Part1.class, "input.txt");
        Terminal terminal = parser.parseToTerminal(lines);
        terminal.moveToRoot();
        return terminal.getCurrentDirectory()
                .getAllDirectoriesRecursive()
                .stream()
                .filter(d -> d != terminal.getRootDirectory())
                .map(Directory::totalSize)
                .filter(s -> s <= 100000)
                .mapToInt(i -> i)
                .sum();
    }
}
