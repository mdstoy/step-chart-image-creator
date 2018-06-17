package com.github.mdstoy.stepchart.model.chart;

public class Position {

    private int position;

    private int resolution;

    private Position(int position, int resolution) {
        this.position = position;
        this.resolution = resolution;
    }

    public static Position of(int position, int resolution) {
        return new Position(position, resolution);
    }

    public int getPosition() {
        return position;
    }

    public int getResolution() {
        return resolution;
    }

    @Override
    public String toString() {
        return String.format("position [%d], resolution [%d]", position, resolution);
    }
}
