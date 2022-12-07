package ch.stewue.aoc2022.day3;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class Part2Test {

    @Test
    public void testSum() throws IOException, URISyntaxException {
        int sum = Part2.getSum();
        assertThat(sum).isEqualTo(70);
    }

    @Test
    public void testGetCompartments() throws IOException, URISyntaxException {
        List<List<String>> compartments = Part2.getCompartments();
        assertThat(compartments).containsExactly(
                List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"),
                List.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw")
        ).inOrder();
    }
}