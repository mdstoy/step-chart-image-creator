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

    // FIXME : これじゃない
    private void setup() throws IOException{
        Arrow down = Arrow.of(imageConfig.getArrow());

        baseArrows.put(Direction.DOWN, down);

        Arrow left = down.clone();
        left.rotate(90);
        baseArrows.put(Direction.LEFT, left);

        Arrow up = down.clone();
        up.rotate(180);
        baseArrows.put(Direction.UP, up);

        Arrow right = down.clone();
        right.rotate(270);
        baseArrows.put(Direction.RIGHT, right);
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
                arrow.changeColor(0, 255, 255);
                break;
            case TRIPLET:
                arrow.changeColor(0, 255, 0);
                break;
            case OTHERS:
                arrow.changeColor(0, 0, 0);
        }
        return arrow;
    }
}
