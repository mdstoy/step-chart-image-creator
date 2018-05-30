package com.github.mdstoy.stepchart.model.chart;

import java.util.Arrays;

public enum Direction {

    LEFT(0),
    DOWN(1),
    UP(2),
    RIGHT(3);

    private int position;

    Direction(int position) {
        this.position = position;
    }

    public static Direction of(int column) {
        return Arrays.stream(values())
                .filter(dir -> dir.position == column % 4)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
