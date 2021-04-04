import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class createGEdge {
    public int max=0;
    public int[][] gRez;
    public int[][] g;
    public float formula=0;
    public void create(int gXPixels[][], int gYPixels[][],int width,int height){
        gRez = new int[width][height];
        g= new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

               int gradientValue = (int) Math.sqrt(Math.pow(gXPixels[i][j], 2) + Math.pow(gYPixels[i][j], 2));
                if(gradientValue>max){
                    max=gradientValue;
                }
                gRez[i][j]=gradientValue;
            }
        }
        formula=(float)max/(float)255;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                g[i][j]=(int)((float)gRez[i][j]/formula);

            }
        }



    }
}
