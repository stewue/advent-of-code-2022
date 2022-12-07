package ch.stewue.aoc2022.day3;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Utils {

    private static final Map<Character, Integer> characters = Maps.newLinkedHashMap();

    static {
        int priority = 1;
        for (int i = 97; i <= 122; i++, priority++) {
            characters.put((char) i, priority);
        }
        for (int i = 65; i <= 90; i++, priority++) {
            characters.put((char) i, priority);
        }
    }

    public static char getDuplicateCharacter(List<String> compartments) {
        for (Character character : characters.keySet()) {
            if (compartments.stream().allMatch(c -> c.contains((Character.toString(character))))) {
                return character;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int getPriority(char character) {
        return Optional.ofNullable(characters.get(character))
                .orElseThrow();
    }
}
