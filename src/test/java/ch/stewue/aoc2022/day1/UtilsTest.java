package ch.stewue.aoc2022.day1;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {
    @Test
    public void testGetSumByElf() throws IOException, URISyntaxException {
        List<Integer> result = Utils.getSumByElf()
                .boxed()
                .toList();

        assertThat(result).containsExactly(6000, 4000, 11000, 24000, 10000).inOrder();
    }
}
