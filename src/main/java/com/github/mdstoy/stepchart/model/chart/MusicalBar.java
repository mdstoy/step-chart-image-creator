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
            int position = index % (resolution / 4);
            String line = bar.get(index);
            for (int column = 0; column < width; ++column) {
                if (line.charAt(column) != '0') {
                    // FIXME : position は note と pos の組み合わせ
                    attributes.add(new ArrowAttribute(null, Direction.of(column)));
                }
            }
        }

        System.out.println(bar.size());
        //FIXME
        return new MusicalBar(null);
    }
}
