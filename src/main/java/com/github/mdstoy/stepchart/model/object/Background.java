package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.chart.Position;
import com.github.mdstoy.stepchart.model.chart.Style;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

// FIXME : こうなると Background という名前と立ち位置がおかしい
public class Background {
    BufferedImage image;
    private BufferedImage result;

    private ArrowContainer arrowContainer;

    private Background(String imagePath, ArrowContainer arrowContainer) throws IOException{
        this.arrowContainer = arrowContainer;
        try {
            this.image = ImageIO.read(new ClassPathResource(imagePath).getFile());
        } catch (IOException ioe) {
            throw new IOException(String.format("failed create image. [%s]", imagePath), ioe);
        }
    }

    public static Background of(String imagePath, ArrowContainer arrowContainer) throws IOException{
        return new Background(imagePath, arrowContainer);
    }

    public void output() throws IOException {
        // FIXME : decide output destination
        scaleImage(0.5d);
        ImageIO.write(result, "png", new File("/tmp/" + System.currentTimeMillis() + ".png"));
    }

    private void scaleImage(double scale) {
        Image dstImage = Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(
                        result.getSource(),
                        new AreaAveragingScaleFilter(
                                (int) (result.getWidth() * scale), (int) (result.getHeight() * scale))));
        result = new BufferedImage(
                (int) (result.getWidth() * scale), (int) (result.getHeight() * scale), BufferedImage.TYPE_INT_RGB);
        result.createGraphics().drawImage(dstImage, 0, 0, null);
    }

    public void put(ArrowAttribute arrowAttribute, int measure) {
        ArrowLocation location = arrowAttribute.getLocation();
        Position position = arrowAttribute.getPosition();
        Arrow arrow = arrowContainer.getArrow(location);
        puta(arrow,
                location.direction.getPosition() * arrow.image.getWidth()
                        + arrowAttribute.getSide().getValue() * arrow.image.getWidth() * 4,
                (position.getPosition() * image.getHeight() / position.getResolution()) + (measure * image.getHeight()));
    }

    private void puta(Arrow arrow, int x, int y) {
        result.getGraphics().drawImage(arrow.image, x, y, null);
    }

    public void extend(int measures, Style style) {
        result = new BufferedImage(image.getWidth() * (style == Style.DOUBLE ? 2 : 1),
                image.getHeight() * measures, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = result.createGraphics();
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
