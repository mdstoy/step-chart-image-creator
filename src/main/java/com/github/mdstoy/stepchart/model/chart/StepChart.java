package com.github.mdstoy.stepchart.model.chart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StepChart {

    private List<MusicalBar> musicalBars;

    Style style;

    private StepChart(List<MusicalBar> musicalBars, Style style) {
        this.musicalBars = musicalBars;
        this.style = style;
    }

    public static StepChart of(Path path) throws IOException {

        int measure = 0;
        Map<Integer, List<String>> bars = new HashMap<>();
        List<String> bar = new ArrayList<>();
        bars.put(measure, bar);
        for (String line : Files.readAllLines(path)) {
            if (line.startsWith(",")) {
                bar = new ArrayList<>();
                bars.put(++measure, bar);
                continue;
            }
            if (line.endsWith(";")) {
                break;
            }

            bar.add(line);
        }

        return new StepChart(bars.entrySet().stream()
                .map(e -> MusicalBar.of(e.getKey(), e.getValue()))
                .collect(Collectors.toList()),
                Style.of(bar.get(0).length())
        );
    }

    public void forEach(Consumer<ArrowAttribute> consumer) {
        musicalBars.stream()
                .flatMap(musicalBar -> musicalBar.attributes.stream())
                .forEach(consumer);
    }

    public int getSize() {
        return musicalBars.size();
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return musicalBars.toString();
    }
}
