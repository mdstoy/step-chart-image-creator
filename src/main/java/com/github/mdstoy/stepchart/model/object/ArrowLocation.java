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

    @Override
    public String toString() {
        return String.format("d[%s] n[%s]", direction, note);
    }
}
