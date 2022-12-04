package ch.stewue.aoc2022.day1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part2Test {
    @Test
    public void testGetMaxCalorie() throws IOException, URISyntaxException {
        int topThreeCalorie = Part2.getTopThreeCalorie();

        assertThat(topThreeCalorie).isEqualTo(45000);
    }
}
