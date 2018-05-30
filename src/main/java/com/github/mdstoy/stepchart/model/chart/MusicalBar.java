package com.github.mdstoy.stepchart.model.chart;

import java.util.ArrayList;
import java.util.List;

public class MusicalBar {

    private List<ArrowAttribute> attributes;

    private MusicalBar(List<ArrowAttribute> attributes) {
        this.attributes = attributes;
    }

    public static MusicalBar of(List<String> bar) {

        final int resolution = bar.size();
        final int width = bar.get(0).length();

        List<ArrowAttribute> attributes = new ArrayList<>();

        for (int index = 0; index < resolution; ++index) {
            String line = bar.get(index);
            for (int column = 0; column < width; ++column) {
                if (line.charAt(column) != '0') {
                    // FIXME : 4分と8分しかない
                    Note note = (index % (resolution / 4)) == 0 ? Note.QUARTER : Note.EIGHTH;
                    Position position = new Position(index / (resolution / 4), note);
                    ArrowAttribute attribute = new ArrowAttribute(position, Direction.of(column), Side.of(column));
                    attributes.add(attribute);
                }
            }
        }

        //FIXME
        return new MusicalBar(attributes);
    }

    @Override
    public String toString() {
        return attributes.toString();
    }
}
