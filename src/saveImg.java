import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class saveImg {
    public void create(String name,int width,int height,int pixels[][]) throws IOException {
        BufferedImage bufimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufimg.createGraphics();
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                //System.out.println(pixels[i][j]);
                g2d.setColor(new Color(pixels[i][j],pixels[i][j],pixels[i][j]));
                g2d.fillRect(i, j, 1, 1);
            }
        }

        g2d.dispose();

        File file = new File("./outputFile/"+name+".jpeg");
        ImageIO.write(bufimg,"jpeg",file);
    }
}
