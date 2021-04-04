public class grayscaleImage {

    public int[][] pixels=null;

    public void createGrayScale(int width,int height,int[][][] pixelsRezerv){
        pixels = new int[width][height];
        for( int col=0 ; col<width; col++){
            for( int row=0 ; row<height ; row++ ){
                //pixels[col][row] = (int)((.2126 * pixelsRezerv[col][row][0]) + (.7152 * pixelsRezerv[col][row][1]) + (.0722 * pixelsRezerv[col][row][2]));
                pixels[col][row] =(int) ((pixelsRezerv[col][row][0] +pixelsRezerv[col][row][1] + pixelsRezerv[col][row][2])/3);
            }
        }



    }
}
