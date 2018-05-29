package com.github.mdstoy.stepchart;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.chart.Direction;
import com.github.mdstoy.stepchart.model.chart.Note;
import com.github.mdstoy.stepchart.model.chart.Position;
import com.github.mdstoy.stepchart.model.object.Arrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ArrowContainer {

    private Map<ArrowAttribute, Arrow> arrows = new HashMap<>();

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
        arrows.put(new ArrowAttribute(new Position(1, Note.QUARTER), Direction.ONE_DOWN), down);

        Arrow left = down.rotate(90);
        arrows.put(new ArrowAttribute(new Position(1, Note.QUARTER), Direction.ONE_LEFT), left);

        Arrow up = down.rotate(180);
        arrows.put(new ArrowAttribute(new Position(1, Note.QUARTER), Direction.ONE_UP), up);

        Arrow right = down.rotate(270);
        arrows.put(new ArrowAttribute(new Position(1, Note.QUARTER), Direction.ONE_RIGHT), right);
    }

    public Arrow getArrow(ArrowAttribute attribute) {
        return arrows.get(attribute);
    }
}
