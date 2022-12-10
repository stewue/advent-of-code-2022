package ch.stewue.aoc2022.day7;

import ch.stewue.aoc2022.day7.filesystem.Directory;
import ch.stewue.aoc2022.day7.filesystem.Terminal;
import ch.stewue.aoc2022.day7.parser.Parser;
import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

public class Part2 {

    public static final int TOTAL_SIZE = 70000000;
    public static final int REQUIRED_SPACE = 30000000;

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("get size of element to delete: %d %n", getElementToDelete().totalSize());
    }

    public static Directory getElementToDelete() throws IOException, URISyntaxException {
        Parser parser = new Parser();
        List<String> lines = FileUtils.getLines(Part2.class, "input.txt");
        Terminal terminal = parser.parseToTerminal(lines);
        terminal.moveToRoot();

        int usedSpace = terminal.getCurrentDirectory().totalSize();
        int unusedSpace = TOTAL_SIZE - usedSpace;
        int spaceRequiredToFree = REQUIRED_SPACE - unusedSpace;

        return terminal.getCurrentDirectory()
                .getAllDirectoriesRecursive()
                .stream()
                .filter(d -> d.totalSize() > spaceRequiredToFree)
                .min(Comparator.comparing(Directory::totalSize))
                .orElseThrow();
    }
}
