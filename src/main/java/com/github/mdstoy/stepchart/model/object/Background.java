package com.github.mdstoy.stepchart.model.object;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    BufferedImage image;

    private Background(BufferedImage image) {
        this.image = image;
    }

    public static Background of(String imagePath) throws IOException{
        BufferedImage image;
        try {
            image = ImageIO.read(new ClassPathResource(imagePath).getFile());
        } catch (IOException ioe) {
            throw new IOException(String.format("failed create image. [%s]", imagePath), ioe);
        }

        return new Background(image);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }
}
