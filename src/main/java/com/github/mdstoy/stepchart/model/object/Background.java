package com.github.mdstoy.stepchart.model.object;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

// FIXME : こうなると Background という名前があれやな
public class Background {
    BufferedImage image;
    private BufferedImage result;
    private Graphics2D graphics;

    private Background(String imagePath) throws IOException{
        try {
            this.image = ImageIO.read(new ClassPathResource(imagePath).getFile());
            // 読み込んだイメージを操作できるように
            graphics = image.createGraphics();

        } catch (IOException ioe) {
            throw new IOException(String.format("failed create image. [%s]", imagePath), ioe);
        }

    }

    public static Background of(String imagePath) throws IOException{
        return new Background(imagePath);
    }

    public void output() throws IOException {
        // FIXME : decide output destination
        ImageIO.write(result, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }

    // TODO : 四分以外を表現せないかん
    // FIXME : 出力先の指定方法
    public void put(Arrow arrow, int measure, int beat, int position) {
        // TODO : 場所に合わせて色と向きを変えなきゃいかん
        puta(arrow, (measure - 1) * image.getHeight() + (beat - 1) * image.getWidth(), position * image.getWidth());
    }

    private void puta(Arrow arrow, int x, int y) {
        graphics.drawImage(arrow.image, x, y, null);
    }

    public void dispose() {
        graphics.dispose();
    }

    public void extend(int size) {
        result = new BufferedImage(image.getWidth(), image.getHeight() * size, BufferedImage.TYPE_INT_RGB);
        graphics = result.createGraphics();
        IntStream.range(0, size)
                .forEach(i -> graphics.drawImage(image, 0, image.getHeight() * i, null));
    }


    /*

            // 変換元 -> 変換先
            arrow.changeColor(255, 255, 0);
            graphics.drawImage(arrow.rotate(90), 92, 48, null);
            graphics.drawImage(arrow.rotate(180), 48, 70, null);
     */
}
