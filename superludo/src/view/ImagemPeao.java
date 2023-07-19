package view;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImagemPeao {
    public BufferedImage createImage(Color color) {
        int diameter = 15;
        BufferedImage image = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        
        g.setColor(color);
        g.fillOval(0, 0, diameter, diameter);
        
        g.dispose();
        
        return image;
    }
}
