package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.usecase.PartialInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StepChartApplication {

    public static void main(String[] args) {
	    try(ConfigurableApplicationContext context = SpringApplication.run(StepChartApplication.class, args)) {
            PartialInput bean = context.getBean(PartialInput.class);
	        bean.run(args);
        } catch (Exception e) {
	        System.err.println(e.getMessage());
        }
    }
}
