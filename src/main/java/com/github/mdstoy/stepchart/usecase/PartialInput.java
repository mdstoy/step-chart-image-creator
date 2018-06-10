package com.github.mdstoy.stepchart.usecase;

import com.github.mdstoy.stepchart.model.chart.Background;
import com.github.mdstoy.stepchart.model.chart.StepChart;
import com.github.mdstoy.stepchart.model.object.BackgroundContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PartialInput {

    private BackgroundContainer backgroundContainer;

    @Autowired
    public PartialInput(BackgroundContainer backgroundContainer) {
        this.backgroundContainer = backgroundContainer;
    }

    public void run(String[] args) throws FileNotFoundException {

        if (args.length != 1) {
            throw new IndexOutOfBoundsException("Required only one option is file path.");
        }

        Path path = Paths.get(args[0]);

        if (Files.notExists(path)) {
            throw new FileNotFoundException(String.format("File not found [%s]", path.toString()));
        }

        try {
            StepChart stepChart = StepChart.of(path);
            Background background = backgroundContainer.getBackground(stepChart.getSize(), stepChart.getStyle());
            stepChart.stream().forEach(arrowAttribute -> background.put(arrowAttribute));
            background.output();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
