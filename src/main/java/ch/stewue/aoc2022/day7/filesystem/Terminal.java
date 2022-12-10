package ch.stewue.aoc2022.day7.filesystem;

import com.google.common.annotations.VisibleForTesting;

import java.util.Optional;

public class Terminal {

    @VisibleForTesting
    Directory rootDirectory = new Directory("/", null);
    @VisibleForTesting
    Directory currentDirectory = rootDirectory;

    public void addElement(Element element) {
        currentDirectory.addElement(element);
    }

    public void moveToRoot() {
        currentDirectory = rootDirectory;
    }

    public void moveToParent() {
        Directory parentDirectory = currentDirectory.getParentDirectory();
        if (parentDirectory == null) {
            throw new IllegalArgumentException("Cannot navigate to parent directory in root directory");
        }
        currentDirectory = parentDirectory;
    }

    public void moveToDirectory(String directoryName) {
        Optional<Element> child = currentDirectory.getChild(directoryName);
        if (child.isPresent() && child.get() instanceof Directory dir) {
            currentDirectory = dir;
        } else {
            throw new IllegalArgumentException("No directory found");
        }
    }

    public String print() {
        StringBuilder output = new StringBuilder();
        printRecursive(rootDirectory, 0, output);
        return output.toString();
    }

    private void printRecursive(Element element, int level, StringBuilder output) {
        output.append("  ".repeat(Math.max(0, level)));
        output.append(String.format("- %s\n", element.toString()));
        if (element instanceof Directory dir) {
            dir.getElements().forEach(e -> printRecursive(e, level + 1, output));
        }
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }
}
