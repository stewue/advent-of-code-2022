package ch.stewue.aoc2022.day8;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part2Test {

    @Test
    public void testHighestScore() throws IOException, URISyntaxException {
        assertThat(Part2.getHighestScore()).isEqualTo(8);
    }

}