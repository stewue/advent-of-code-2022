package ch.stewue.aoc2022.day6;

import java.util.List;

public class Utils {
    public static int getFirstStartPacket(String input, int length) {
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .toList();

        for (int i = length; i < characters.size(); i++) {
            long numberOfDistinctCharacters = characters.subList(i - length, i)
                    .stream()
                    .distinct()
                    .count();
            if (numberOfDistinctCharacters == length) {
                return i;
            }
        }

        return -1;
    }

}
