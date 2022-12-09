package ch.stewue.aoc2022.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

public class Part1Test {

    @Test
    public void testNumberFullOverlap() throws IOException, URISyntaxException {
        assertThat(Part1.getNumberFullOverlap()).isEqualTo(2);
    }

    @Test(dataProvider = "hasFullOverlap")
    public void testHasFullOverlap(Range testee, Range tested, boolean contained) {
        assertThat(Part1.hasFullOverlap(testee, tested)).isEqualTo(contained);
    }

    @DataProvider
    public Object[][] hasFullOverlap() {
        return new Object[][]{
                new Object[]{new Range(2, 4), new Range(6, 8), false},
                new Object[]{new Range(2, 3), new Range(4, 5), false},
                new Object[]{new Range(5, 7), new Range(7, 9), false},
                new Object[]{new Range(2, 8), new Range(3, 7), false},
                new Object[]{new Range(3, 7), new Range(2, 8), true},
                new Object[]{new Range(6, 6), new Range(4, 6), true},
                new Object[]{new Range(4, 6), new Range(6, 6), false},
                new Object[]{new Range(2, 6), new Range(4, 8), false}
        };
    }

}