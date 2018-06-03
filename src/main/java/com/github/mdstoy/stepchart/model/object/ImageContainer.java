package com.github.mdstoy.stepchart.model.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ImageContainer {

    private BackgroundGenerator backgroundGenerator;

    private ArrowGenerator arrowGenerator;

    private Map<ArrowLocation, Arrow> arrowCache = new HashMap<>();

    @Autowired
    public ImageContainer(BackgroundGenerator backgroundGenerator, ArrowGenerator arrowGenerator) {
        this.backgroundGenerator = backgroundGenerator;
        this.arrowGenerator = arrowGenerator;
    }

    public Arrow getArrow(ArrowLocation location) {
        return arrowCache.getOrDefault(location, getNewArrow(location));
    }

    private Arrow getNewArrow(ArrowLocation location) {
        Arrow newArrow = arrowGenerator.getArrow(location);
        arrowCache.put(location, newArrow);
        return newArrow;
    }

    public Background getBackground(int size) throws IOException {
        return backgroundGenerator.getBackground(size);
    }

}
