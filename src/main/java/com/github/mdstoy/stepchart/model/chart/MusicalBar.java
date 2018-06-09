package com.github.mdstoy.stepchart.model.chart;

import com.github.mdstoy.stepchart.model.object.ArrowLocation;

import java.util.ArrayList;
import java.util.List;

public class MusicalBar {

    List<ArrowAttribute> attributes;

    private MusicalBar(List<ArrowAttribute> attributes, Style style) {
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
                    ArrowAttribute attribute = ArrowAttribute.of(Position.of(index, resolution),
                            Side.of(column), ArrowLocation.of(Direction.of(column), note));
                    attributes.add(attribute);
                }
            }
        }

        return new MusicalBar(attributes, Style.of(width));
    }

    void createImage(Background background, int measure) {
        attributes.stream().forEach(arrowAttribute -> background.put(arrowAttribute, measure));
    }

    @Override
    public String toString() {
        return attributes.toString();
    }
}
