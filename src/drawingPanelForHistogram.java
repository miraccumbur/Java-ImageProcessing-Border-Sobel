import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class drawingPanelForHistogram extends JPanel {
        int width,height,max;
        List<Integer[]> pixels;
        public drawingPanelForHistogram(int width, int height, List<Integer[]> pixel,int max){

            this.width = width;
            this.height = height;
            this.pixels = pixel;
            this.max = max;

        }

    public void paintComponent(Graphics g){

        float formula=max/500;
            //int size = pixels[col];
            //g.setColor(new Color(255,0,0));
           // g.drawLine(col,height,col,height-size);






        for(int i =0;i<pixels.size();i++){
            for(int j =0;j<pixels.size();j++){
                g.setColor(new Color(0,255,0));
                g.drawLine(j*10,500,j*10,450);
            }
            g.setColor(new Color(0,0,0));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[0]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[1]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[2]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[3]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[4]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[5]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[6]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[7]/formula));
            g.drawLine(i,500,i,500-(int)((float)pixels.get(i)[8]/formula));
        }

    }
}
