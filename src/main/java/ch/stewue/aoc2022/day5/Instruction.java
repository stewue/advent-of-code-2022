package ch.stewue.aoc2022.day5;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instruction {
    private static final Pattern MOVE_PATTERN = Pattern.compile("move ([0-9]*) from ([0-9]*) to ([0-9]*)");

    private final int amount;
    private final int from;
    private final int to;

    public Instruction(int amount, int from, int to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public Instruction(String rawLine) {
        Matcher matcher = MOVE_PATTERN.matcher(rawLine);
        if (matcher.matches()) {
            amount = Integer.parseInt(matcher.group(1));
            from = Integer.parseInt(matcher.group(2));
            to = Integer.parseInt(matcher.group(3));
        } else {
            throw new IllegalStateException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return amount == that.amount && from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, from, to);
    }
}