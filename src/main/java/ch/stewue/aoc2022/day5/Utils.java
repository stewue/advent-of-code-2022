package ch.stewue.aoc2022.day5;

import ch.stewue.aoc2022.utils.FileUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Utils {

    public static final BiFunction<State, Instruction, Void> FOFI_BIFUNCTION = (state, instruction) -> {
        state.applyFoFi(instruction);
        return null;
    };

    public static final BiFunction<State, Instruction, Void> FOLI_BIFUNCTION = (state, instruction) -> {
        state.applyFoLi(instruction);
        return null;
    };

    public static State execute(BiFunction<State, Instruction, Void> function) throws IOException, URISyntaxException {
        State state = new State(getRawInitialState());
        parseInstructions().forEach(i -> function.apply(state, i));
        return state;
    }

    @VisibleForTesting
    public static List<String> getRawInitialState() throws IOException, URISyntaxException {
        return Lists.newArrayList(getPart()[0].split("\n"));
    }

    private static List<Instruction> parseInstructions() throws IOException, URISyntaxException {
        return Arrays.stream(getPart()[1].split("\n"))
                .map(Instruction::new)
                .toList();
    }

    private static String[] getPart() throws IOException, URISyntaxException {
        List<String> lines = FileUtils.getLines(Utils.class, "input.txt");
        return String.join("\n", lines).split("\n\n");
    }
}
