import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a txt name:");
        String fileName= scan.nextLine();

        scanTxtFile scanTxtFile=new scanTxtFile();
        scanTxtFile.scanFile("./originalImageTXT/"+fileName+".txt");

        int width=scanTxtFile.width;
        int height=scanTxtFile.height;


        int[][][] pixelsForOriginal=scanTxtFile.pixels;
        grayscaleImage grayscaleImage = new grayscaleImage();
        grayscaleImage.createGrayScale(width,height,pixelsForOriginal);
        int[][] pixelsForGrayscale=grayscaleImage.pixels;

        createVerticalEdge createVerticalEdge = new createVerticalEdge();
        createVerticalEdge.create(width,height,pixelsForGrayscale);
        int [][] gX=createVerticalEdge.gX;

        createHorizontalEdge createHorizontalEdge = new createHorizontalEdge();
        createHorizontalEdge.create(width,height,pixelsForGrayscale);
        int [][] gY=createHorizontalEdge.gY;

        createGEdge createGEdge = new createGEdge();
        createGEdge.create(gX,gY,width,height);
        int [][] g=createGEdge.g;

        histogram histogram = new histogram();
        histogram.createHistogram(width,height,pixelsForGrayscale);
        List<Integer[]> forHistogram = histogram.histogramCount;
        int max = histogram.max;

        saveImg saveImg = new saveImg();
        saveImg.create(fileName,width,height,g);


        drawingPanelFor2Byte drawingTab1 = new drawingPanelFor2Byte(width,height,pixelsForGrayscale);
        drawingPanelFor2Byte drawingTab2 = new drawingPanelFor2Byte(width,height,gX);
        drawingPanelFor2Byte drawingTab3 = new drawingPanelFor2Byte(width,height,gY);
        drawingPanelFor2Byte drawingTab4 = new drawingPanelFor2Byte(width,height,g);
        drawingPanelForHistogram drawingTab5 = new drawingPanelForHistogram(width,height,forHistogram,max);


        final JFrame frame = new JFrame("Mirac Cumbur");
        frame.setSize(1920,1080);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1,1));


        JTabbedPane tabbedpane = new JTabbedPane(JTabbedPane.TOP);
        tabbedpane.addTab("Tab1",drawingTab1);
        tabbedpane.addTab("Tab2",drawingTab2);
        tabbedpane.addTab("Tab3",drawingTab3);
        tabbedpane.addTab("Tab4",drawingTab4);
        tabbedpane.addTab("Tab5",drawingTab5);
        frame.getContentPane().add(tabbedpane);

        drawingTab1.addMouseListener(new MouseAdapter() {
            int[] getX=new int[2];
            int[] getY=new int[2];
            int count=0;
            @Override
            public void mousePressed(MouseEvent e) {
                if (count < 2) {

                        getX[count] = e.getX();
                        getY[count] = e.getY();

                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.getX() < pixelsForOriginal.length && e.getY() < pixelsForOriginal[0].length) {
                    count++;
                    if (count == 2) {
                        drawingTab6 createDrawingTab6 = new drawingTab6();
                        createDrawingTab6.create(getX,getY,pixelsForGrayscale);
                        int[][] tab6Pixels =createDrawingTab6.createdPixels;
                        tabbedpane.addTab("Tab6", new drawingPanelFor2Byte(tab6Pixels.length, tab6Pixels[0].length, tab6Pixels));
                    }
                }
            }
        });

    }
}
