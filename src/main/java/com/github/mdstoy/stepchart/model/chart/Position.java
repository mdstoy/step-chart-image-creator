package com.github.mdstoy.stepchart.model.chart;

public class Position {

    int measure;

    Note note;

    public Position(int measure, Note note) {
        this.measure = measure;
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("measure [%d], note [%s]", measure, note);
    }
}
