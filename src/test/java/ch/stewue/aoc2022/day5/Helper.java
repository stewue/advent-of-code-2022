package ch.stewue.aoc2022.day5;

import java.util.LinkedHashMap;
import java.util.Stack;

public class Helper {
    public static Stack<Character> getStack(Character... characters) {
        Stack<Character> stack = new Stack<>();
        for (Character character : characters) {
            stack.push(character);
        }
        return stack;
    }

    @SafeVarargs
    public static State getState(Stack<Character>... stacks) {
        LinkedHashMap<Integer, Stack<Character>> map = new LinkedHashMap<>();
        for (int i = 0; i < stacks.length; i++) {
            map.put(i + 1, stacks[i]);
        }
        return new State(map);
    }
}
