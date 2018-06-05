package com.github.mdstoy.stepchart.model.chart;

import com.github.mdstoy.stepchart.model.object.ArrowLocation;

public class ArrowAttribute {

    Position position;

    Side side;

    ArrowLocation location;

    private ArrowAttribute(Position position, Side side, ArrowLocation location) {
        this.position = position;
        this.side = side;
        this.location = location;
    }

    public static ArrowAttribute of(Position position, Side side, ArrowLocation location) {
        return new ArrowAttribute(position, side, location);
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
