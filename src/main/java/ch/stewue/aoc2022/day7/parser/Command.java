package ch.stewue.aoc2022.day7.parser;

import ch.stewue.aoc2022.day7.filesystem.Terminal;

public interface Command {

    void execute(Terminal terminal);
}
