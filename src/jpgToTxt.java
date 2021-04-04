import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class jpgToTxt {
    BufferedImage image;
    int width,height;
    String type = "2";
    String maxValue = "255";



    public jpgToTxt(){
        try {
            File input = new File("mirac-vsco.jpg");
            File outputFile = new File("./originalImageTXT/mirac-vsco.txt");
            FileOutputStream fos = new FileOutputStream(outputFile);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            bw.write(type);
            bw.newLine();
            bw.write(width+" "+height);
            bw.newLine();
            bw.write(maxValue);
            bw.newLine();

            System.out.println("Width:"+width+" Height:"+height);

            int count = 0;

            for(int i=0; i<height; i++) {

                for(int j=0; j<width; j++) {

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    //System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                    bw.write(c.getRed()+" "+c.getGreen()+" "+c.getBlue()+" ");

                }
            }
            bw.close();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        jpgToTxt jpgToTxt = new jpgToTxt();
    }
}

