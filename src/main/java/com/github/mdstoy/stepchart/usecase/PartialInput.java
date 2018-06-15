package com.github.mdstoy.stepchart.usecase;

import com.github.mdstoy.stepchart.model.object.ChartImage;
import com.github.mdstoy.stepchart.model.chart.StepChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class PartialInput {

    private ChartImage chartImage;

    @Autowired
    public PartialInput(ChartImage chartImage) {
        this.chartImage = chartImage;
    }

    public void run(Path path) {

        try {
            StepChart stepChart = StepChart.of(path);
            chartImage.extend(stepChart.getSize(), stepChart.getStyle());
            stepChart.forEach(arrowAttribute -> chartImage.put(arrowAttribute));
            chartImage.output();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
