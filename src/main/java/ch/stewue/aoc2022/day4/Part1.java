package ch.stewue.aoc2022.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.BiFunction;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("number of full overlaps: %d %n", getNumberFullOverlap());
    }

    public static long getNumberFullOverlap() throws IOException, URISyntaxException {
        BiFunction<Range, Range, Boolean> matchFunction = (first, second)
                -> hasFullOverlap(first, second) || hasFullOverlap(second, first);
        return Utils.getNumberOfMatches(matchFunction);
    }

    public static boolean hasFullOverlap(Range testee, Range tested) {
        return tested.from() <= testee.from() && testee.to() <= tested.to();
    }
}
