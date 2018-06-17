package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import com.github.mdstoy.stepchart.model.chart.ArrowLocation;
import com.github.mdstoy.stepchart.model.chart.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowGenerator {

    private Map<Direction, Arrow> baseArrows = new HashMap<>();

    private ImageConfiguration imageConfig;

    @Autowired
    public ArrowGenerator(ImageConfiguration imageConfig) throws IOException{
        this.imageConfig = imageConfig;
        setup();
    }

    private void setup() throws IOException{
        baseArrows.put(Direction.LEFT, Arrow.of(imageConfig.getLeft()));
        baseArrows.put(Direction.DOWN, Arrow.of(imageConfig.getDown()));
        baseArrows.put(Direction.UP, Arrow.of(imageConfig.getUp()));
        baseArrows.put(Direction.RIGHT, Arrow.of(imageConfig.getRight()));
    }

    private Arrow getNewArrow(Direction direction) {
        return baseArrows.get(direction).clone();
    }

    public Arrow getArrow(ArrowLocation location) {
        Arrow arrow = getNewArrow(location.getDirection());
        switch (location.getNote()) {
            case QUARTER:
                arrow.changeColor(255, 0, 0);
                break;
            case EIGHTH:
                arrow.changeColor(0, 0, 255);
                break;
            case SIXTEENTH:
                arrow.changeColor(255, 255, 0);
                break;
            case TRIPLET:
                arrow.changeColor(0, 255, 0);
                break;
            case OTHERS:
                arrow.changeColor(128, 255, 255);
        }
        return arrow;
    }
}
