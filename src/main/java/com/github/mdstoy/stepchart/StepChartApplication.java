package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.model.chart.StepChart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class StepChartApplication {

    public static void main(String[] args) {
	    try(ConfigurableApplicationContext context = SpringApplication.run(StepChartApplication.class, args)) {
            StepChartApplication stepChart = context.getBean(StepChartApplication.class);
	        stepChart.run(args);
        } catch (Exception e) {
	        System.err.println(e.getMessage());
        }
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
