package ch.stewue.aoc2022.day1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {
    @Test
    public void testGetMaxCalorie() throws IOException, URISyntaxException {
        int maxCalorie = Part1.getMaxCalorie();

        assertThat(maxCalorie).isEqualTo(24000);
    }
}
