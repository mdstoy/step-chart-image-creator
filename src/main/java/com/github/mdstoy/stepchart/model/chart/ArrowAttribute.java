package com.github.mdstoy.stepchart.model.chart;

public class ArrowAttribute {

    // FIXME : これをどう作るか

    Position position;

    Direction direction;

    Side side;

    Note note;

    private ArrowAttribute(Position position, Direction direction, Side side, Note note) {
        this.position = position;
        this.direction = direction;
        this.side = side;
        this.note = note;
    }

    public static ArrowAttribute of(Position position, Direction direction, Side side, Note note) {
        return new ArrowAttribute(position, direction, side, note);
    }

    @Override
    public String toString() {
        return String.format("p[%s] d[%s] s[%s] n[%s]", position, direction, side, note);
    }
}
