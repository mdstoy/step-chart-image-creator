package com.github.mdstoy.stepchart.model.chart;

public class ArrowAttribute {

    private Integer measure;

    private Position position;

    private Side side;

    private ArrowLocation location;

    private ArrowAttribute(Integer measure, Position position, Side side, ArrowLocation location) {
        this.measure = measure;
        this.position = position;
        this.side = side;
        this.location = location;
    }

    public static ArrowAttribute of(Integer measure, Position position, Side side, ArrowLocation location) {
        return new ArrowAttribute(measure, position, side, location);
    }

    public Integer getMeasure() {
        return measure;
    }

    public Position getPosition() {
        return position;
    }

    public Side getSide() {
        return side;
    }

    public ArrowLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("p[%s] s[%s] l[%s]", position, side, location);
    }
}
