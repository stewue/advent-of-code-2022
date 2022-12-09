package ch.stewue.aoc2022.day5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class InstructionTest {

    @Test(dataProvider = "instructions")
    public void testParseInstructions(String rawInput, Instruction expectedInstruction) {
        assertThat(new Instruction(rawInput)).isEqualTo(expectedInstruction);
    }

    @DataProvider
    public Object[][] instructions() {
        return new Object[][]{
                new Object[]{"move 1 from 2 to 1", new Instruction(1, 2, 1)},
                new Object[]{"move 3 from 1 to 3", new Instruction(3, 1, 3)},
                new Object[]{"move 2 from 2 to 1", new Instruction(2, 2, 1)},
                new Object[]{"move 1 from 1 to 2", new Instruction(1, 1, 2)}
        };
    }
}