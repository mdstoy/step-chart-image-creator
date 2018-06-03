package com.github.mdstoy.stepchart.model.chart;

import com.github.mdstoy.stepchart.model.object.Background;
import com.github.mdstoy.stepchart.model.object.ImageContainer;

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
        bars.add(bar);
        for (String line : Files.readAllLines(path)) {
            if (line.startsWith(",")) {
                bar = new ArrayList<>();
                bars.add(bar);
                continue;
            }
            if (line.endsWith(";")) {
                break;
            }

            bar.add(line);
        }

        return new StepChart(bars.stream()
                .map(MusicalBar::of)
                .collect(Collectors.toList())
        );
    }

    public void createImage(ImageContainer imageContainer) throws IOException{
        Background background = imageContainer.getBackground(musicalBars.size());
        background.output();
    }

    @Override
    public String toString() {
        return musicalBars.toString();
    }
}
