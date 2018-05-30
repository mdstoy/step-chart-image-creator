package com.github.mdstoy.stepchart.model.chart;

public class ArrowAttribute {

    Position position;

    Direction direction;

    Side side;

    public ArrowAttribute(Position position, Direction direction, Side side) {
        this.position = position;
        this.direction = direction;
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("p[%s] d[%s] s[%s]", position, direction, side);
    }
}
