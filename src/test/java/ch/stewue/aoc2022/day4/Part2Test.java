package ch.stewue.aoc2022.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part2Test {

    @Test
    public void testNumberPartialOverlap() throws IOException, URISyntaxException {
        assertThat(Part2.getNumberPartialOverlap()).isEqualTo(4);
    }

    @Test(dataProvider = "hasPartialOverlap")
    public void testHasPartialOverlap(Utils.Range testee, Utils.Range tested, boolean contained) {
        assertThat(Part2.hasPartialOverlap(testee, tested)).isEqualTo(contained);
    }

    @DataProvider
    public Object[][] hasPartialOverlap() {
        return new Object[][]{
                new Object[]{new Utils.Range(2, 4), new Utils.Range(6, 8), false},
                new Object[]{new Utils.Range(2, 3), new Utils.Range(4, 5), false},
                new Object[]{new Utils.Range(5, 7), new Utils.Range(7, 9), true},
                new Object[]{new Utils.Range(3, 7), new Utils.Range(2, 8), true},
                new Object[]{new Utils.Range(6, 6), new Utils.Range(4, 6), true},
                new Object[]{new Utils.Range(2, 6), new Utils.Range(4, 8), true}
        };
    }

}