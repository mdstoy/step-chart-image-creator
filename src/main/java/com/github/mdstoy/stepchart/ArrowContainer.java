package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.config.ArrowConfiguration;
import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.object.Arrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowContainer {

    private Map<ArrowAttribute, Arrow> arrows = new HashMap<>();

    private ArrowConfiguration arrowConfig;

    @Autowired
    public ArrowContainer(ArrowConfiguration arrowConfig) throws IOException{
        this.arrowConfig = arrowConfig;
        setup();
    }

    // FIXME : これじゃない
    private void setup() throws IOException{
        Arrow arrow = Arrow.of(arrowConfig.getImagePath());
        arrows.put(null, arrow);
    }

    public Arrow getArrow(ArrowAttribute attribute) {
        return arrows.get(attribute);
    }
}
