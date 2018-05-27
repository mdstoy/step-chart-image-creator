package com.github.mdstoy.stepchart.model.chart;

public class ArrowAttribute {

    Position position;

    Direction direction;

    ArrowAttribute(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("position [%s] Direction [%s]", position, direction);
    }
}
