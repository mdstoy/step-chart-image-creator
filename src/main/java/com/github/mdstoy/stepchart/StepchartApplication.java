package com.github.mdstoy.stepchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class StepchartApplication {

    public static void main(String[] args) {
	    try(ConfigurableApplicationContext context = SpringApplication.run(StepchartApplication.class, args)) {
	        StepchartApplication application = context.getBean(StepchartApplication.class);
	        application.run(args);
        } catch (Exception e) {
	        // FIXME
	        e.printStackTrace();
        }
    }

    public void run(String[] args) {
        System.out.println("args:");
        Arrays.stream(args).forEach(System.out::println);
    }
}
