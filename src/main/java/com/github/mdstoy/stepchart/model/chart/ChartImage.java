package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.chart.ArrowLocation;
import com.github.mdstoy.stepchart.model.chart.Position;
import com.github.mdstoy.stepchart.model.chart.Style;
import com.github.mdstoy.stepchart.model.object.Arrow;
import com.github.mdstoy.stepchart.model.object.ArrowContainer;
import com.github.mdstoy.stepchart.model.object.Background;
import com.github.mdstoy.stepchart.model.object.BackgroundGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

@Component
public class ChartImage {

    private Background background;

    private ArrowContainer arrowContainer;

    private BufferedImage result;

    @Autowired
    public ChartImage(BackgroundGenerator backgroundGenerator, ArrowContainer arrowContainer) throws IOException{
        this.background = backgroundGenerator.getBackground();
        this.arrowContainer = arrowContainer;
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

    public void put(ArrowAttribute arrowAttribute) {
        ArrowLocation location = arrowAttribute.getLocation();
        Position position = arrowAttribute.getPosition();
        Arrow arrow = arrowContainer.getArrow(location);
        puta(arrow,
                location.getDirection().getPosition() * arrow.getWidth()
                        + arrowAttribute.getSide().getValue() * arrow.getWidth() * 4,
                (position.getPosition() * background.getHeight() / position.getResolution())
                        + (arrowAttribute.getMeasure() * background.getHeight()));
    }

    private void puta(Arrow arrow, int x, int y) {
        result.getGraphics().drawImage(arrow.image, x, y, null);
    }

    public void extend(int measures, Style style) {
        result = new BufferedImage(background.getWidth() * (style == Style.DOUBLE ? 2 : 1),
                background.getHeight() * measures, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = result.createGraphics();
        // FIXME : 雑すぎる
        IntStream.range(0, measures)
                .forEach(i -> {
                    graphics.drawImage(background.image, 0, background.getHeight() * i, null);
                    if (style == Style.DOUBLE) {
                        graphics.drawImage(background.image, background.getWidth(), background.getHeight() * i, null);
                    }
                });
    }
}
