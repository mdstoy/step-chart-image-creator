package com.github.mdstoy.stepchart.model.object;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
        BufferedImage newImage = src.getSubimage(0, 0, src.getWidth(), src.getHeight());
        return new Arrow(newImage);
    }

    @Override
    public Arrow clone() {
        return Arrow.of(image);
    }

    public void changeColor(int r, int g, int b) {
        /*
        for(int i = 0; i < image.getHeight(); ++i) {
            for(int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == -16777216) {
                    image.setRGB(i, j, (255 << 24) + (r << 16) + (g << 8) + b);
                } else {
                    image.setRGB(i, j, 0);
                }
            }
        }
        */
    }

    public void rotate(int angle) {
        // 変換の設定
        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.toRadians(angle), image.getWidth() / 2, image.getHeight() / 2);
        // 変換の実操作
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);

        // 書き出し用
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        op.filter(image, newImage);

        this.image = newImage;
    }
}
