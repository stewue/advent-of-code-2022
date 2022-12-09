package ch.stewue.aoc2022.day5;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

public class State {

    private LinkedHashMap<Integer, Stack<Character>> stacks = Maps.newLinkedHashMap();

    public State(LinkedHashMap<Integer, Stack<Character>> stacks) {
        this.stacks = stacks;
    }

    public State(List<String> lines) {
        Collections.reverse(lines);

        parseLine(lines.get(0)).forEach(i -> stacks.put(Integer.parseInt(String.valueOf(i)), new Stack<>()));

        for (int n = 1; n < lines.size(); n++) {
            List<Character> characters = parseLine(lines.get(n));
            List<Stack<Character>> stackList = Lists.newArrayList(stacks.values());
            for (int m = 0; m < stackList.size(); m++) {
                if (m < characters.size()) {
                    Character character = characters.get(m);
                    if (character != 32) {
                        stackList.get(m).push(character);
                    }
                }
            }
        }
    }

    // first out first in
    public void applyFoFi(Instruction instruction) {
        Stack<Character> fromStack = stacks.get(instruction.getFrom());
        Stack<Character> toStack = stacks.get(instruction.getTo());

        for (int i = 0; i < instruction.getAmount(); i++) {
            Character character = fromStack.pop();
            toStack.push(character);
        }
    }

    // first out last in
    public void applyFoLi(Instruction instruction) {
        Stack<Character> fromStack = stacks.get(instruction.getFrom());
        Stack<Character> toStack = stacks.get(instruction.getTo());

        Stack<Character> movingStack = new Stack<>();
        for (int i = 0; i < instruction.getAmount(); i++) {
            Character character = fromStack.pop();
            movingStack.push(character);
        }
        for (int i = 0; i < instruction.getAmount(); i++) {
            Character character = movingStack.pop();
            toStack.push(character);
        }
    }

    public String getTopString() {
        return stacks.values()
                .stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public LinkedHashMap<Integer, Stack<Character>> getStacks() {
        return stacks;
    }

    private static List<Character> parseLine(String line) {
        byte[] bytes = line.getBytes();
        List<Character> resultList = Lists.newArrayList();
        for (int position = 1; position < bytes.length; position += 4) {
            resultList.add((char) bytes[position]);
        }
        return resultList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(stacks, state.stacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stacks);
    }
}