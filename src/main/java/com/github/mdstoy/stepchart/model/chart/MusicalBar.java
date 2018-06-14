package com.github.mdstoy.stepchart.model.chart;

import java.util.ArrayList;
import java.util.List;

public class MusicalBar {

    List<ArrowAttribute> attributes;

    private MusicalBar(List<ArrowAttribute> attributes) {
        this.attributes = attributes;
    }

    public static MusicalBar of(Integer measure, List<String> bar) {

        final int resolution = bar.size();
        final int width = bar.get(0).length();

        List<ArrowAttribute> attributes = new ArrayList<>();

        for (int index = 0; index < resolution; ++index) {
            String line = bar.get(index);
            Position position = Position.of(index, resolution);
            Note note = Note.of(index, resolution);
            for (int column = 0; column < width; ++column) {
                if (line.charAt(column) != '0') {
                    ArrowAttribute attribute = ArrowAttribute.of(
                            measure,
                            position,
                            Side.of(column),
                            ArrowLocation.of(Direction.of(column), note)
                    );
                    attributes.add(attribute);
                }
            }
        }

        return new MusicalBar(attributes);
    }

    @Override
    public String toString() {
        return attributes.toString();
    }
}
