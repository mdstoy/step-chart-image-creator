package com.github.mdstoy.stepchart;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowContainer {

    private Map<ArrowAttribute, BufferedImage> arrows;

    public ArrowContainer() {
        arrows = new HashMap<>();
    }

    public BufferedImage getArrow(ArrowAttribute attribute) {
        return arrows.get(attribute);
    }
}
