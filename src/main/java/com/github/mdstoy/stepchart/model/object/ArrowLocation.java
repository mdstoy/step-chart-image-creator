package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.Direction;
import com.github.mdstoy.stepchart.model.chart.Note;

public class ArrowLocation {

    Direction direction;

    Note note;

    private ArrowLocation(Direction direction, Note note) {
        this.direction = direction;
        this.note = note;
    }

    public static ArrowLocation of(Direction direction, Note note) {
        return new ArrowLocation(direction, note);
    }

    // FIXME : Background を分離して、これは消せるようにする
    public int getPosition() {
        return direction.getPosition();
    }

    @Override
    public String toString() {
        return String.format("d[%s] n[%s]", direction, note);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrowLocation) {
            ArrowLocation anotherLocation = (ArrowLocation) obj;
            return anotherLocation.direction == direction && anotherLocation.note == note;
        }
        return false;
    }

    @Override
    public int hashCode() {
        String combined = direction.toString() + note.toString();
        return combined.hashCode();
    }
}
