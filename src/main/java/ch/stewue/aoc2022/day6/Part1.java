package ch.stewue.aoc2022.day6;

import ch.stewue.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Part1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String input = String.join("", FileUtils.getLines(Part1.class, "input.txt"));
        System.out.printf("first start-of-packet marker at position: %d %n", Utils.getFirstStartPacket(input, 4));
    }
}
