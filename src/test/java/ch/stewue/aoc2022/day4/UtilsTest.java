package ch.stewue.aoc2022.day4;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {
    @Test
    public void testGetPairs() throws IOException, URISyntaxException {
        assertThat(Utils.getPairs()).containsExactly(
                        new Pair(new Range(2, 4), new Range(6, 8)),
                        new Pair(new Range(2, 3), new Range(4, 5)),
                        new Pair(new Range(5, 7), new Range(7, 9)),
                        new Pair(new Range(2, 8), new Range(3, 7)),
                        new Pair(new Range(6, 6), new Range(4, 6)),
                        new Pair(new Range(2, 6), new Range(4, 8))
                )
                .inOrder();
    }

}