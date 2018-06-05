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

    Style style;

    private StepChart(List<MusicalBar> musicalBars, Style style) {
        this.musicalBars = musicalBars;
        this.style = style;
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
                .collect(Collectors.toList()),
                Style.of(bar.get(0).length())
        );
    }

    public void createImage(ImageContainer imageContainer) throws IOException{
        Background background = imageContainer.getBackground(musicalBars.size(), style);
        musicalBars.stream()
                .forEach(musicalBar -> musicalBar.createImage(background));
        background.output();
    }

    @Override
    public String toString() {
        return musicalBars.toString();
    }
}
