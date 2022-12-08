package ch.stewue.aoc2022.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.BiFunction;

public class Part2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("number of partial overlaps: %d %n", getNumberPartialOverlap());
    }

    public static long getNumberPartialOverlap() throws IOException, URISyntaxException {
        BiFunction<Utils.Range, Utils.Range, Boolean> matchFunction = (first, second)
                -> hasPartialOverlap(first, second) || hasPartialOverlap(second, first);
        return Utils.getNumberOfMatches(matchFunction);
    }

    public static boolean hasPartialOverlap(Utils.Range testee, Utils.Range tested) {
        return tested.from() <= testee.from() && testee.from() <= tested.to()
                || tested.from() <= testee.to() && testee.to() <= tested.to();
    }
}
