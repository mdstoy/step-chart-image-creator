package com.github.mdstoy.stepchart;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class StepChart {

    private StepChart() {
        // TODO
    }

    public static StepChart of(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        lines.stream().forEach(System.out::println);
        return new StepChart();
    }
}
