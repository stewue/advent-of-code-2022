package ch.stewue.aoc2022.day7.parser;

import ch.stewue.aoc2022.day7.filesystem.Terminal;
import ch.stewue.aoc2022.utils.FileUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ParserTest {

    @Test
    public void testParseToTerminal() throws URISyntaxException, IOException {
        Parser parser = new Parser();
        List<String> lines = FileUtils.getLines(Parser.class, "../input.txt");
        Terminal terminal = parser.parseToTerminal(lines);

        assertThat(terminal.print()).isEqualTo(
                """
                        - / (dir)
                          - a (dir)
                            - e (dir)
                              - i (file, size=584)
                            - f (file, size=29116)
                            - g (file, size=2557)
                            - h.lst (file, size=62596)
                          - b.txt (file, size=14848514)
                          - c.dat (file, size=8504156)
                          - d (dir)
                            - j (file, size=4060174)
                            - d.log (file, size=8033020)
                            - d.ext (file, size=5626152)
                            - k (file, size=7214296)
                        """
        );
    }
}