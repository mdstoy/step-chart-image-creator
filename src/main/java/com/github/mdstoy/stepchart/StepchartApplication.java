package com.github.mdstoy.stepchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class StepchartApplication {

    public static void main(String[] args) {
	    try(ConfigurableApplicationContext context = SpringApplication.run(StepchartApplication.class, args)) {
            StepchartApplication stepchart = context.getBean(StepchartApplication.class);
	        stepchart.run(args);
        } catch (Exception e) {
	        // FIXME
	        e.printStackTrace();
        }
    }

    public void run(String[] args) {

        if (args.length != 1) {
            throw new IndexOutOfBoundsException("usage: command path");
        }

        try {
            // TODO : use component
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            lines.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
