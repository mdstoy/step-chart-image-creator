package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.ArrowLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowContainer {

    private ArrowGenerator arrowGenerator;

    private Map<ArrowLocation, Arrow> arrowCache = new HashMap<>();

    @Autowired
    public ArrowContainer(ArrowGenerator arrowGenerator) {
        this.arrowGenerator = arrowGenerator;
    }

    public Arrow getArrow(ArrowLocation location) {
        return arrowCache.computeIfAbsent(location, arrowGenerator::getArrow);
    }
}
