package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ImageContainer {

    private BackgroundGenerator backgroundGenerator;

    @Autowired
    public ImageContainer(BackgroundGenerator backgroundGenerator) {
        this.backgroundGenerator = backgroundGenerator;
    }

    public Background getBackground(int size, Style style) throws IOException {
        return backgroundGenerator.getBackground(size, style);
    }
}
