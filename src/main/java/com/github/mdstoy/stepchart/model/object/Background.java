package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.chart.Position;
import com.github.mdstoy.stepchart.model.chart.Style;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

// FIXME : こうなると Background という名前と立ち位置がおかしい
public class Background {
    BufferedImage image;
    private BufferedImage result;
    private Graphics2D graphics;

    private ArrowContainer arrowContainer;

    private Background(String imagePath, ArrowContainer arrowContainer) throws IOException{
        this.arrowContainer = arrowContainer;
        try {
            this.image = ImageIO.read(new ClassPathResource(imagePath).getFile());
            // 読み込んだイメージを操作できるように
            graphics = image.createGraphics();

        } catch (IOException ioe) {
            throw new IOException(String.format("failed create image. [%s]", imagePath), ioe);
        }
    }

    public static Background of(String imagePath, ArrowContainer arrowContainer) throws IOException{
        return new Background(imagePath, arrowContainer);
    }

    public void output() throws IOException {
        // FIXME : decide output destination
        dispose();
        ImageIO.write(result, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }

    // TODO : 四分以外を表現せないかん
    // FIXME : 出力先の指定方法
    public void put(ArrowAttribute arrowAttribute, int measure) {
        ArrowLocation location = arrowAttribute.getLocation();
        Position position = arrowAttribute.getPosition();
        Arrow arrow = arrowContainer.getArrow(location);
        // FIXME : magic number
        System.out.println(arrowAttribute);
        puta(arrow,
                location.direction.getPosition() * 48
                        + arrowAttribute.getSide().getValue() * 48 * 4,
                (position.getPosition() * image.getHeight() / position.getResolution()) + (measure * image.getHeight()));
    }

    private void puta(Arrow arrow, int x, int y) {
        System.out.printf("%d, %d", x, y);
        graphics.drawImage(arrow.image, x, y, null);
    }

    public void dispose() {
        graphics.dispose();
    }

    public void extend(int measures, Style style) {
        result = new BufferedImage(image.getWidth() * (style == Style.DOUBLE ? 2 : 1),
                image.getHeight() * measures, BufferedImage.TYPE_INT_RGB);
        graphics = result.createGraphics();
        // FIXME : 雑すぎる
        IntStream.range(0, measures)
                .forEach(i -> {
                    graphics.drawImage(image, 0, image.getHeight() * i, null);
                    if (style == Style.DOUBLE) {
                        graphics.drawImage(image, image.getWidth(), image.getHeight() * i, null);
                    }
                });
    }
}
