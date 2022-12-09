package ch.stewue.aoc2022.day5;

import java.io.IOException;
import java.net.URISyntaxException;

public class Part2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.printf("top characters: %s %n", Utils.execute(Utils.FOLI_BIFUNCTION).getTopString());
    }

}
