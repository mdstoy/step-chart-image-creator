package com.github.mdstoy.stepchart;

public enum Direction {

    ONE_LEFT(0),
    ONE_DOWN(1),
    ONE_UP(2),
    ONE_RIGHT(3),
    TWO_LEFT(4),
    TWO_DOWN(5),
    TWO_UP(6),
    TWO_RIGHT(7);

    private int position;

    Direction(int position) {
        this.position = position;
    }
}
