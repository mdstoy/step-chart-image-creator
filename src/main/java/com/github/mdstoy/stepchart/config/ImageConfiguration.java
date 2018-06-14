package com.github.mdstoy.stepchart.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "image")
@Component
public class ImageConfiguration {

    private String left;

    private String down;

    private String up;

    private String right;

    private String background;

    public String getLeft() {
        return left;
    }

    public String getDown() {
        return down;
    }

    public String getUp() {
        return up;
    }

    public String getRight() {
        return right;
    }

    public String getBackground() {
        return background;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
