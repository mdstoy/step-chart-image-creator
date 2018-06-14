package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.usecase.PartialInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class StepChartApplication {

    public static void main(String[] args) {

	    try(ConfigurableApplicationContext context = SpringApplication.run(StepChartApplication.class, args)) {
            if (args.length != 1) {
                throw new IndexOutOfBoundsException("Required only one option is file path.");
            }

            Path path = Paths.get(args[0]);

            if (Files.notExists(path)) {
                throw new FileNotFoundException(String.format("File not found [%s]", path.toString()));
            }

            PartialInput bean = context.getBean(PartialInput.class);
	        bean.run(path);
        } catch (Exception e) {
	        e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
