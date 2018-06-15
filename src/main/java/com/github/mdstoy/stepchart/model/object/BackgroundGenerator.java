package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.config.ImageConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BackgroundGenerator {

    private ImageConfiguration imageConfig;

    @Autowired
    public BackgroundGenerator(ImageConfiguration imageConfig) {
        this.imageConfig = imageConfig;
    }

    public Background getBackground() throws IOException {
        return Background.of(imageConfig.getBackground());
    }
}
