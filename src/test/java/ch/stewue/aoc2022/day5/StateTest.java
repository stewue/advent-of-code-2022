package ch.stewue.aoc2022.day5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static ch.stewue.aoc2022.day5.Helper.getStack;
import static ch.stewue.aoc2022.day5.Helper.getState;
import static com.google.common.truth.Truth.assertThat;

public class StateTest {

    private static final State INITIAL_STATE_FOFI = getState(
            getStack('Z', 'N'),
            getStack('M', 'C', 'D'),
            getStack('P')
    );
    private static final State STATE_FOFI_1 = getState(
            getStack('Z', 'N', 'D'),
            getStack('M', 'C'),
            getStack('P')
    );
    private static final State STATE_FOFI_2 = getState(
            getStack(),
            getStack('M', 'C'),
            getStack('P', 'D', 'N', 'Z')
    );

    private static final State STATE_FOFI_3 = getState(
            getStack('C', 'M'),
            getStack(),
            getStack('P', 'D', 'N', 'Z')
    );

    private static final State STATE_FOFI_4 = getState(
            getStack('C'),
            getStack('M'),
            getStack('P', 'D', 'N', 'Z')
    );

    private static final State INITIAL_STATE_FOLI = getState(
            getStack('Z', 'N'),
            getStack('M', 'C', 'D'),
            getStack('P')
    );

    private static final State STATE_FOLI_1 = getState(
            getStack('Z', 'N', 'D'),
            getStack('M', 'C'),
            getStack('P')
    );

    private static final State STATE_FOLI_2 = getState(
            getStack(),
            getStack('M', 'C'),
            getStack('P', 'Z', 'N', 'D')
    );

    private static final State STATE_FOLI_3 = getState(
            getStack('M', 'C'),
            getStack(),
            getStack('P', 'Z', 'N', 'D')
    );

    private static final State STATE_FOLI_4 = getState(
            getStack('M'),
            getStack('C'),
            getStack('P', 'Z', 'N', 'D')
    );

    private static final Instruction INSTRUCTION_1 = new Instruction(1, 2, 1);
    private static final Instruction INSTRUCTION_2 = new Instruction(3, 1, 3);
    private static final Instruction INSTRUCTION_3 = new Instruction(2, 2, 1);
    private static final Instruction INSTRUCTION_4 = new Instruction(1, 1, 2);

    @Test(dataProvider = "FoFi")
    public void testFoFi(State initialState, Instruction instruction, State finalState) {
        initialState.applyFoFi(instruction);
        assertThat(initialState).isEqualTo(finalState);
    }

    @DataProvider
    public Object[][] FoFi() {
        return new Object[][]{
                new Object[]{INITIAL_STATE_FOFI, INSTRUCTION_1, STATE_FOFI_1},
                new Object[]{STATE_FOFI_1, INSTRUCTION_2, STATE_FOFI_2},
                new Object[]{STATE_FOFI_2, INSTRUCTION_3, STATE_FOFI_3},
                new Object[]{STATE_FOFI_3, INSTRUCTION_4, STATE_FOFI_4}
        };
    }

    @Test(dataProvider = "FoLi")
    public void testFoLi(State initialState, Instruction instruction, State finalState) {
        initialState.applyFoLi(instruction);
        assertThat(initialState).isEqualTo(finalState);
    }

    @DataProvider
    public Object[][] FoLi() {
        return new Object[][]{
                new Object[]{INITIAL_STATE_FOLI, INSTRUCTION_1, STATE_FOLI_1},
                new Object[]{STATE_FOLI_1, INSTRUCTION_2, STATE_FOLI_2},
                new Object[]{STATE_FOLI_2, INSTRUCTION_3, STATE_FOLI_3},
                new Object[]{STATE_FOLI_3, INSTRUCTION_4, STATE_FOLI_4}
        };
    }

    @Test
    public void testParseInitialState() throws IOException, URISyntaxException {
        State state = new State(Utils.getRawInitialState());
        assertThat(state.getStacks()).containsExactly(
                1, getStack('Z', 'N'),
                2, getStack('M', 'C', 'D'),
                3, getStack('P')
        ).inOrder();
    }

    @Test
    public void testTopString() {
        State state = getState(
                getStack('C'),
                getStack('M'),
                getStack('P', 'D', 'N', 'Z')
        );
        assertThat(state.getTopString()).isEqualTo("CMZ");
    }
}