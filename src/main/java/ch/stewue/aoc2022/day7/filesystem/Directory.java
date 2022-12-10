package ch.stewue.aoc2022.day7.filesystem;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Directory implements Element {

    private final String name;
    private final Directory parentDirectory;
    private final List<Element> elements = Lists.newArrayList();

    public Directory(String name, Directory parentDirectory) {
        this.name = name;
        this.parentDirectory = parentDirectory;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public Optional<Element> getChild(String childName) {
        return elements.stream()
                .filter(e -> e.getName().equals(childName))
                .findFirst();
    }

    public List<Directory> getAllDirectoriesRecursive() {
        Stream<Directory> childStream = elements.stream()
                .filter(e -> e instanceof Directory)
                .map(e -> (Directory) e)
                .map(Directory::getAllDirectoriesRecursive)
                .flatMap(Collection::stream);

        return Stream.concat(childStream, Stream.of(this))
                .toList();
    }

    @Override
    public Integer totalSize() {
        return elements.stream()
                .map(Element::totalSize)
                .mapToInt(i -> i)
                .sum();
    }

    @Override
    public String getName() {
        return name;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return String.format("%s (dir)", name);
    }
}
