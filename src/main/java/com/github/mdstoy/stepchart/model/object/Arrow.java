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

    public static Arrow of(Arrow src) {
        BufferedImage newImage = src.image.getSubimage(0, 0, src.image.getWidth(), src.image.getHeight());
        return new Arrow(newImage);
    }

    // FIXME : インスタンスの扱い
    public BufferedImage changeColor(int r, int g, int b) {
        for(int i = 0; i < image.getHeight(); ++i) {
            for(int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == -16777216) {
                    image.setRGB(i, j, (255 << 24) + (r << 16) + (g << 8) + b);
                } else {
                    image.setRGB(i, j, 0);
                }
            }
        }

        return image;
    }

    public BufferedImage rotate(int angle) {
        // 変換の設定
        AffineTransform at = new AffineTransform();
        // TODO : 24d は取ってくる？
        at.setToRotation(Math.toRadians(angle), 24d, 24d);
        // 変換の実操作
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);

        // 書き出し用
        // TODO : 48 は取ってくる
        BufferedImage newImage = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);
        op.filter(image, newImage);

        return newImage;
    }
}
