package com.github.mdstoy.stepchart.model.chart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StepChart {

    private List<MusicalBar> musicalBars;

    private StepChart(List<MusicalBar> musicalBars) {
        this.musicalBars = musicalBars;
    }

    public static StepChart of(Path path) throws IOException {

        List<List<String>> bars = new ArrayList<>();
        List<String> bar = new ArrayList<>();
        for (String line : Files.readAllLines(path)) {
            if (line.matches("[,;]")) {
                bars.add(bar);
                bar = new ArrayList<>();
                continue;
            }

            bar.add(line);
        }

        return new StepChart(bars.stream()
                .map(MusicalBar::of)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return musicalBars.toString();
    }
}
