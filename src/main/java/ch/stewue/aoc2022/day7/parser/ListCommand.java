package ch.stewue.aoc2022.day7.parser;

import ch.stewue.aoc2022.day7.filesystem.Directory;
import ch.stewue.aoc2022.day7.filesystem.File;
import ch.stewue.aoc2022.day7.filesystem.Terminal;

import java.util.List;

public class ListCommand implements Command {

    public static final String NAME = "ls";

    private final List<String> output;

    public ListCommand(List<String> output) {
        this.output = output;
    }

    @Override
    public void execute(Terminal terminal) {
        output.forEach(l -> {
            String[] parts = l.split(" ", 2);

            if ("dir".equals(parts[0])) {
                terminal.addElement(new Directory(parts[1], terminal.getCurrentDirectory()));
            } else {
                terminal.addElement(new File(parts[1], Integer.parseInt(parts[0])));
            }
        });
    }
}
