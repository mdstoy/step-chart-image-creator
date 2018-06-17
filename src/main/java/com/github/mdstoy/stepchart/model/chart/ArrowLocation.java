package com.github.mdstoy.stepchart.model.chart;

public class ArrowLocation {

    private Direction direction;

    private Note note;

    private ArrowLocation(Direction direction, Note note) {
        this.direction = direction;
        this.note = note;
    }

    public static ArrowLocation of(Direction direction, Note note) {
        return new ArrowLocation(direction, note);
    }

    public Direction getDirection() {
        return direction;
    }

    public Note getNote() {
        return note;
    }

    @Override
    public String toString() {
        return String.format("d[%s] n[%s]", getDirection(), getNote());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrowLocation) {
            ArrowLocation anotherLocation = (ArrowLocation) obj;
            return anotherLocation.getDirection() == getDirection() && anotherLocation.getNote() == getNote();
        }
        return false;
    }

    @Override
    public int hashCode() {
        String combined = getDirection().toString() + getNote().toString();
        return combined.hashCode();
    }
}
