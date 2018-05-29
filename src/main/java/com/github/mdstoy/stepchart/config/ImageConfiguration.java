package com.github.mdstoy.stepchart.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "image")
@Component
public class ImageConfiguration {

    private String arrow;

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getArrow() {
        return arrow;
    }
}
