package com.github.mdstoy.stepchart.model.chart;

public class ArrowAttribute {

    Integer measure;

    Position position;

    Side side;

    ArrowLocation location;

    private ArrowAttribute(Integer measure, Position position, Side side, ArrowLocation location) {
        this.measure = measure;
        this.position = position;
        this.side = side;
        this.location = location;
    }

    public static ArrowAttribute of(Integer measure, Position position, Side side, ArrowLocation location) {
        return new ArrowAttribute(measure, position, side, location);
    }

    @Override
    public String toString() {
        return String.format("p[%s] s[%s] l[%s]", position, side, location);
    }
}
