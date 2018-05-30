package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import com.github.mdstoy.stepchart.model.chart.Direction;
import com.github.mdstoy.stepchart.model.chart.Note;
import com.github.mdstoy.stepchart.model.object.Arrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowContainer {

    private Map<Direction, Arrow> baseArrows = new HashMap<>();

    private ImageConfiguration imageConfig;

    @Autowired
    public ArrowContainer(ImageConfiguration imageConfig) throws IOException{
        this.imageConfig = imageConfig;
        setup();
    }

    // FIXME : これじゃない
    private void setup() throws IOException{
        Arrow down = Arrow.of(imageConfig.getArrow());

        // FIXME : model の定義がおかしい？
        baseArrows.put(Direction.DOWN, down);

        Arrow left = down.clone();
        down.rotate(90);
        baseArrows.put(Direction.LEFT, left);

        Arrow up = down.clone();
        down.rotate(180);
        baseArrows.put(Direction.UP, up);

        Arrow right = down.clone();
        down.rotate(270);
        baseArrows.put(Direction.RIGHT, right);
    }

    public Arrow getArrow(Direction direction) {
        return baseArrows.get(direction).clone();
    }

    public Arrow getArrow(Direction direction, Note note) {
        Arrow arrow = getArrow(direction).clone();
        switch (note) {
            case QUARTER:
                arrow.changeColor(255, 0, 0);
            case EIGHTH:
                arrow.changeColor(0, 0, 255);
            case SIXTEENTH:
                arrow.changeColor(0, 255, 255);
            case TRIPLET:
                arrow.changeColor(0, 255, 0);
            case OTHERS:
                // FIXME : 何色？
                arrow.changeColor(0, 0, 0);
        }
        return baseArrows.get(direction);
    }
}
