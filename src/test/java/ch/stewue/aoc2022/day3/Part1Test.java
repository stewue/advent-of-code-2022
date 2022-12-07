package ch.stewue.aoc2022.day3;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {

    @Test
    public void testSum() throws IOException, URISyntaxException {
        int sum = Part1.getSum();
        assertThat(sum).isEqualTo(157);
    }

    @Test
    public void testGetCompartments() throws IOException, URISyntaxException {
        List<List<String>> compartments = Part1.getCompartments();
        assertThat(compartments).containsExactly(
                List.of("vJrwpWtwJgWr", "hcsFMMfFFhFp"),
                List.of("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"),
                List.of("PmmdzqPrV", "vPwwTWBwg"),
                List.of("wMqvLMZHhHMvwLH", "jbvcjnnSBnvTQFn"),
                List.of("ttgJtRGJ", "QctTZtZT"),
                List.of("CrZsJsPPZsGz", "wwsLwLmpwMDw")
        ).inOrder();
    }
}