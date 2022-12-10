package ch.stewue.aoc2022.day6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {

    @Test(dataProvider = "firstStartPacket")
    public void testFirstStartPacket(String input, int length, int expectedPosition) {
        assertThat(Utils.getFirstStartPacket(input, length)).isEqualTo(expectedPosition);
    }

    @DataProvider
    public Object[][] firstStartPacket() {
        return new Object[][]{
                new Object[]{"mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4, 7},
                new Object[]{"bvwbjplbgvbhsrlpgdmjqwftvncz", 4, 5},
                new Object[]{"nppdvjthqldpwncqszvftbrmjlhg", 4, 6},
                new Object[]{"nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4, 10},
                new Object[]{"zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4, 11},
                new Object[]{"mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14, 19},
                new Object[]{"bvwbjplbgvbhsrlpgdmjqwftvncz", 14, 23},
                new Object[]{"nppdvjthqldpwncqszvftbrmjlhg", 14, 23},
                new Object[]{"nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14, 29},
                new Object[]{"zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14, 26}
        };
    }

}