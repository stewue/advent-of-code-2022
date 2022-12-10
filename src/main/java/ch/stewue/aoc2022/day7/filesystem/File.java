package ch.stewue.aoc2022.day7.filesystem;

public record File(String name, int size) implements Element {

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer totalSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("%s (file, size=%d)", name, size);
    }
}
