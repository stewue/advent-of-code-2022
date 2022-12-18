package ch.stewue.aoc2022.day9;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {

    @Test
    public void testNumberOfVisited() throws IOException, URISyntaxException {
        assertThat(Part1.numberOfVisited()).isEqualTo(13);
    }

}