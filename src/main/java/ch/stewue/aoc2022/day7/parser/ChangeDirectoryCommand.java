package ch.stewue.aoc2022.day7.parser;

import ch.stewue.aoc2022.day7.filesystem.Terminal;

public class ChangeDirectoryCommand implements Command {

    public static final String NAME = "cd ";

    private final String directory;

    public ChangeDirectoryCommand(String executedCommand) {
        directory = executedCommand.substring(NAME.length());
    }

    @Override
    public void execute(Terminal terminal) {
        if ("/".equals(directory)) {
            terminal.moveToRoot();
        } else if ("..".equals(directory)) {
            terminal.moveToParent();
        } else {
            terminal.moveToDirectory(directory);
        }
    }
}
