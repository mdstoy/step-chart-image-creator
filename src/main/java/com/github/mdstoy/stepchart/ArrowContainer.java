package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import com.github.mdstoy.stepchart.model.chart.Direction;
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

        Arrow left = down.rotate(90);
        baseArrows.put(Direction.LEFT, left);

        Arrow up = down.rotate(180);
        baseArrows.put(Direction.UP, up);

        Arrow right = down.rotate(270);
        baseArrows.put(Direction.RIGHT, right);
    }

    public Arrow getArrow(Direction attribute) {
        return baseArrows.get(attribute);
    }
}
