package ch.stewue.aoc2022.day5;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static ch.stewue.aoc2022.day5.Helper.getStack;
import static com.google.common.truth.Truth.assertThat;

public class UtilsTest {

    @Test
    public void testFoFi() throws IOException, URISyntaxException {
        State finalState = Utils.execute(Utils.FOFI_BIFUNCTION);
        assertThat(finalState.getStacks()).containsExactly(
                1, getStack('C'),
                2, getStack('M'),
                3, getStack('P', 'D', 'N', 'Z')
        ).inOrder();
    }

    @Test
    public void testFoLi() throws IOException, URISyntaxException {
        State finalState = Utils.execute(Utils.FOLI_BIFUNCTION);
        assertThat(finalState.getStacks()).containsExactly(
                1, getStack('M'),
                2, getStack('C'),
                3, getStack('P', 'Z', 'N', 'D')
        ).inOrder();
    }


}