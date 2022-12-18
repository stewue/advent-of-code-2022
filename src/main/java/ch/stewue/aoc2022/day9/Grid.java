package ch.stewue.aoc2022.day9;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Grid {
    private Coordinate currentHeadPosition = new Coordinate(0, 0);
    private Coordinate currentTailPosition = currentHeadPosition;
    private final List<Coordinate> headPositions = Lists.newArrayList();
    private final List<Coordinate> tailPositions = Lists.newArrayList();
    private final Map<Coordinate, Integer> tailCounter = Maps.newHashMap();

    public void getMap(List<Motion> motions) {
        motions.forEach(m -> {
            for (int i = 0; i < m.count(); i++) {
                currentHeadPosition = currentHeadPosition.nextHeadCoordinate(m.direction());
                headPositions.add(currentHeadPosition);
                currentTailPosition = currentTailPosition.nextTailCoordinate(currentHeadPosition);
                tailPositions.add(currentTailPosition);
                incrementCount(currentTailPosition);
            }
        });
    }

    private void incrementCount(Coordinate currentPosition) {
        Integer count = tailCounter.getOrDefault(currentPosition, 0);
        tailCounter.put(currentPosition, count + 1);
    }

    public List<Coordinate> getHeadPositions() {
        return headPositions;
    }

    public List<Coordinate> getTailPositions() {
        return tailPositions;
    }

    public Map<Coordinate, Integer> getTailCounter() {
        return tailCounter;
    }
}
