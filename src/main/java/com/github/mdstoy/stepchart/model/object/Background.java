package com.github.mdstoy.stepchart.model.object;

import com.github.mdstoy.stepchart.model.chart.ArrowAttribute;
import com.github.mdstoy.stepchart.model.chart.Position;
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
    public void put(ArrowAttribute arrowAttribute) {
        ArrowLocation location = arrowAttribute.getLocation();
        Position position = arrowAttribute.getPosition();
        Arrow arrow = arrowContainer.getArrow(location);
        // FIXME : magic number
        puta(arrow,
                location.direction.getPosition() * 48
                        + arrowAttribute.getSide().getValue() * 48,
                position.getPosition() * image.getHeight() / position.getResolution());
    }

    private void puta(Arrow arrow, int x, int y) {
        System.out.printf("%s, %d, %d\n", arrow.image, x, y);
        Arrow a = null;
        try {
            a = Arrow.of("image/down.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        graphics.drawImage(a.image, x, y, null);
        //graphics.drawImage(arrow.image, x, y, null);
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
