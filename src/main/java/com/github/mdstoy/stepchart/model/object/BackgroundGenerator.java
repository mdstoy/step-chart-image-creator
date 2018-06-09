package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import com.github.mdstoy.stepchart.model.chart.Background;
import com.github.mdstoy.stepchart.model.chart.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BackgroundGenerator {

    private ImageConfiguration imageConfig;

    // FIXME : ここにあるのおかしいやろ
    private ArrowContainer arrowContainer;

    @Autowired
    public BackgroundGenerator(ImageConfiguration imageConfig, ArrowContainer arrowContainer) {
        this.imageConfig = imageConfig;
        this.arrowContainer = arrowContainer;
    }

    public Background getBackground(int size, Style style) throws IOException {
        Background background = Background.of(imageConfig.getBackground(), arrowContainer);
        background.extend(size, style);
        return background;
    }
}
