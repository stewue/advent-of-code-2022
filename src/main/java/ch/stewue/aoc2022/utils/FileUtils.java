package ch.stewue.aoc2022.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class FileUtils {
    public static List<String> getLines(Class clazz, String filename) throws URISyntaxException, IOException {
        URL resource = clazz.getResource(filename);
        return Files.readAllLines(new File(resource.toURI()).toPath());
    }
}
