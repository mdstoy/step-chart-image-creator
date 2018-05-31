package com.github.mdstoy.stepchart.usecase;

import com.github.mdstoy.stepchart.model.object.ArrowContainer;
import com.github.mdstoy.stepchart.model.chart.StepChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PartialInput {

    private ArrowContainer arrowContainer;

    @Autowired
    public PartialInput(ArrowContainer arrowContainer) {
        this.arrowContainer = arrowContainer;
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
            stepChart.createImage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
