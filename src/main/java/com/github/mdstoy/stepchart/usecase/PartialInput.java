package com.github.mdstoy.stepchart.usecase;

import com.github.mdstoy.stepchart.model.chart.Background;
import com.github.mdstoy.stepchart.model.chart.StepChart;
import com.github.mdstoy.stepchart.model.object.BackgroundGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class PartialInput {

    private BackgroundGenerator backgroundGenerator;

    @Autowired
    public PartialInput(BackgroundGenerator backgroundGenerator) {
        this.backgroundGenerator = backgroundGenerator;
    }

    public void run(Path path) {

        try {
            StepChart stepChart = StepChart.of(path);
            Background background = backgroundGenerator.getBackground(stepChart.getSize(), stepChart.getStyle());
            stepChart.forEach(arrowAttribute -> background.put(arrowAttribute));
            background.output();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
