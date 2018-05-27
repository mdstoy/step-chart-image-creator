package com.github.mdstoy.stepchart;

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
        System.out.println(">>>>>>>>>>>>>>>>>>>>" + args[0]);
	    try(ConfigurableApplicationContext context = SpringApplication.run(StepChartApplication.class, args)) {
            StepChartApplication stepChart = context.getBean(StepChartApplication.class);
	        stepChart.run(args);
        } catch (Exception e) {
	        System.err.println(e.getMessage());
        }
    }

    public void run(String[] args) throws FileNotFoundException {
        System.out.println("++++++++++++++++++" + args);

        if (args.length != 1) {
            throw new IndexOutOfBoundsException("Required only one option is file path. [" + args.length + "]");
        }

        Path path = Paths.get(args[0]);

        if (Files.notExists(path)) {
            throw new FileNotFoundException(String.format("File not found [%s]", path.toString()));
        }

        try {
            StepChart stepChart = StepChart.of(path);
            // TODO : use component
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
