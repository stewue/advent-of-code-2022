package ch.stewue.aoc2022.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {

    @Test(dataProvider = "duplicateCharacter")
    public void testDuplicateCharacter(List<String> compartments, char result) {
        assertThat(Utils.getDuplicateCharacter(compartments)).isEqualTo(result);
    }

    @DataProvider
    public Object[][] duplicateCharacter() {
        return new Object[][]{
                new Object[]{List.of("aA", "aA"), 'a'},
                new Object[]{List.of("Aa", "aA"), 'a'},
                new Object[]{List.of("Aa", "Aa"), 'a'},
                new Object[]{List.of("ab", "ba"), 'a'},
                new Object[]{List.of("bA", "bA"), 'b'},
                new Object[]{List.of("AB", "AB"), 'A'},
                new Object[]{List.of("vJrwpWtwJgWr", "hcsFMMfFFhFp"), 'p'},
                new Object[]{List.of("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"), 'L'},
                new Object[]{List.of("PmmdzqPrV", "vPwwTWBwg"), 'P'},
                new Object[]{List.of("wMqvLMZHhHMvwLH", "jbvcjnnSBnvTQFn"), 'v'},
                new Object[]{List.of("ttgJtRGJ", "QctTZtZT"), 't'},
                new Object[]{List.of("CrZsJsPPZsGz", "wwsLwLmpwMDw"), 's'},
                new Object[]{List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"), 'r'},
                new Object[]{List.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"), 'Z'}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDuplicateCharacterInvalid() {
        Utils.getDuplicateCharacter(List.of("a", "b"));
    }

    @Test(dataProvider = "priority")
    public void testPriority(char character, int priority) {
        assertThat(Utils.getPriority(character)).isEqualTo(priority);
    }

    @DataProvider
    public Object[][] priority() {
        return new Object[][]{
                new Object[]{'a', 1},
                new Object[]{'p', 16},
                new Object[]{'r', 18},
                new Object[]{'s', 19},
                new Object[]{'t', 20},
                new Object[]{'v', 22},
                new Object[]{'z', 26},
                new Object[]{'A', 27},
                new Object[]{'L', 38},
                new Object[]{'P', 42},
                new Object[]{'Z', 52},
        };
    }
}