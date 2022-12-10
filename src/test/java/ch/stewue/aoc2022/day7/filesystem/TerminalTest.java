package ch.stewue.aoc2022.day7.filesystem;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class TerminalTest extends AbstractFilesystem {

    @Test(dataProvider = "moveToRoot")
    public void testMoveToRoot(Directory currentDirectory) {
        Terminal terminal = getTerminal(currentDirectory);
        terminal.moveToRoot();
        assertThat(terminal.getCurrentDirectory()).isEqualTo(ROOT);
    }

    @DataProvider
    public Object[][] moveToRoot() {
        return new Object[][]{
                new Object[]{ROOT},
                new Object[]{D1},
                new Object[]{D11},
                new Object[]{D3},
                new Object[]{D4}
        };
    }

    @Test(dataProvider = "moveToParent")
    public void testMoveToParent(Directory currentDirectory, Directory parentDirectory) {
        Terminal terminal = getTerminal(currentDirectory);
        terminal.moveToParent();
        assertThat(terminal.getCurrentDirectory()).isEqualTo(parentDirectory);
    }

    @DataProvider
    public Object[][] moveToParent() {
        return new Object[][]{
                new Object[]{D1, ROOT},
                new Object[]{D11, D1},
                new Object[]{D3, ROOT},
                new Object[]{D4, ROOT}
        };
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Cannot navigate to parent directory in root directory"
    )
    public void testMoveToParentInvalid() {
        Terminal terminal = getTerminal(ROOT);
        terminal.moveToParent();
    }

    @Test(dataProvider = "moveToDirectory")
    public void testMoveToDirectory(Directory directory) {
        Terminal terminal = getTerminal(ROOT);
        terminal.moveToDirectory(directory.getName());
        assertThat(terminal.getCurrentDirectory()).isEqualTo(directory);
    }

    @DataProvider
    public Object[][] moveToDirectory() {
        return new Object[][]{
                new Object[]{D1},
                new Object[]{D3},
                new Object[]{D4}
        };
    }

    @Test(
            dataProvider = "moveToDirectoryNotFound",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No directory found"
    )
    public void testMoveToDirectoryNotFound(String directory) {
        Terminal terminal = getTerminal(ROOT);
        terminal.moveToDirectory(directory);
    }

    @DataProvider
    public Object[][] moveToDirectoryNotFound() {
        return new Object[][]{
                new Object[]{D11.getName()},
                new Object[]{F2.getName()}
        };
    }

    @Test
    public void testPrint() {
        Terminal terminal = getTerminal(ROOT);
        String output = terminal.print();

        assertThat(output).isEqualTo(
                """
                        - / (dir)
                          - d1 (dir)
                            - d11 (dir)
                              - f111 (file, size=10)
                              - f112 (file, size=27)
                            - f12 (file, size=22)
                            - f13 (file, size=7)
                          - f2 (file, size=32)
                          - d3 (dir)
                            - f31 (file, size=53)
                          - d4 (dir)
                        """
        );
    }

    private Terminal getTerminal(Directory currentDirectory) {
        Terminal terminal = new Terminal();
        terminal.rootDirectory = ROOT;
        terminal.currentDirectory = currentDirectory;
        return terminal;
    }
}