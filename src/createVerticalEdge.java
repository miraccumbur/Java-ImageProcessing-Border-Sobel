public class createVerticalEdge {
    public int max=0;
    public int[][] gXrez;
    public int[][] gX;
    public float formula=0;

    public void create(int width, int height, int[][] pixesl) {
        gXrez = new int[width][height];
        gX= new int[width][height];
        for (int i = 0; i < width-1; i++) {
            for (int j = 0; j < height-1; j++) {
if(i!=0&&j!=0){
    int val00 = pixesl[i - 1][j - 1];
    int val01 = pixesl[i][j - 1];
    int val02 = pixesl[i + 1][j - 1];
    int val10 = pixesl[i - 1][j];
    int val11 = pixesl[i][j];
    int val12 = pixesl[i + 1][j];
    int val20 = pixesl[i - 1][j + 1];
    int val21 = pixesl[i][j + 1];
    int val22 = pixesl[i + 1][j + 1];

    int gradientX = ((1 * val00) + (0 * val01) + (-1 * val02)) + ((2 * val10) + (0 * val11) + (-2 * val12))
            + ((1 * val20) + (0 * val21) + (-1 * val22));


    if(gradientX>max){
        max=gradientX;
    }

    gXrez[i][j]=gradientX;

}


            }

        }
        formula=(float)max/(float)255;

        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {

                    gX[i][j]=Math.abs((int)((float)gXrez[i][j]/formula));



            }
        }
    }


}

