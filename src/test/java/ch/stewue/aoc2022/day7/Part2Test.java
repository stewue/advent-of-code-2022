package ch.stewue.aoc2022.day7;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part2Test {

    @Test
    public void testParseToTerminal() throws URISyntaxException, IOException {
        assertThat(Part2.getElementToDelete().totalSize()).isEqualTo(24933642);
    }
}