package com.github.mdstoy.stepchart.model.object;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Arrow implements Cloneable{

    BufferedImage image;

    private Arrow(String imagePath) throws IOException{
        try {
            this.image = ImageIO.read(new ClassPathResource(imagePath).getFile());
        } catch(IOException ioe) {
            throw new IOException(String.format("failed create image. [%s]", imagePath), ioe);
        }

    }

    private Arrow(BufferedImage image) {
        this.image = image;
    }

    public static Arrow of(String imagePath) throws IOException{
        return new Arrow(imagePath);
    }

    private static Arrow of(BufferedImage src) {
        BufferedImage dist = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        dist.setData(src.getData());
        return new Arrow(dist);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public Arrow clone() {
        return Arrow.of(image);
    }

    public void changeColor(int r, int g, int b) {
        for(int i = 0; i < image.getHeight(); ++i) {
            for(int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == -16777216) {
                    image.setRGB(i, j, (255 << 24) + (r << 16) + (g << 8) + b);
                } else {
                    image.setRGB(i, j, 0);
                }
            }
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
