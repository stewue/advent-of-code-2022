package ch.stewue.aoc2022.day7;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {

    @Test
    public void testParseToTerminal() throws URISyntaxException, IOException {
        assertThat(Part1.getTotalSize()).isEqualTo(95437);
    }
}