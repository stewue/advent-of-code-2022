package ch.stewue.aoc2022.day7.parser;

import ch.stewue.aoc2022.day7.filesystem.Terminal;
import com.google.common.collect.Lists;

import java.util.List;

public class Parser {
    public Terminal parseToTerminal(List<String> lines) {
        Terminal terminal = new Terminal();
        List<String> commands = Lists.newArrayList(String.join("\n", lines).split("\\$ "));
        commands.subList(1, commands.size())
                .forEach(c -> {
                    String[] commandString = c.split("\n", 2);
                    String executedCommand = commandString[0];
                    List<String> output = List.of(commandString[1].split("\n"));

                    Command command;
                    if (executedCommand.startsWith(ListCommand.NAME)) {
                        command = new ListCommand(output);
                    } else if (executedCommand.startsWith(ChangeDirectoryCommand.NAME)) {
                        command = new ChangeDirectoryCommand(executedCommand);
                    } else {
                        throw new IllegalArgumentException("Not supported command");
                    }
                    command.execute(terminal);
                });

        return terminal;
    }
}
