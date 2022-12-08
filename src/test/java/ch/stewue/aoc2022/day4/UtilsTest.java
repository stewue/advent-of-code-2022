package ch.stewue.aoc2022.day4;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {
    @Test
    public void testGetPairs() throws IOException, URISyntaxException {
        assertThat(Utils.getPairs()).containsExactly(
                        new Utils.Pair(new Utils.Range(2, 4), new Utils.Range(6, 8)),
                        new Utils.Pair(new Utils.Range(2, 3), new Utils.Range(4, 5)),
                        new Utils.Pair(new Utils.Range(5, 7), new Utils.Range(7, 9)),
                        new Utils.Pair(new Utils.Range(2, 8), new Utils.Range(3, 7)),
                        new Utils.Pair(new Utils.Range(6, 6), new Utils.Range(4, 6)),
                        new Utils.Pair(new Utils.Range(2, 6), new Utils.Range(4, 8))
                )
                .inOrder();
    }

}