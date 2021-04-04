public class createHorizontalEdge {
    public int max=0;
    public int[][] gYrez;
    public int[][] gY;
    public float formula=0;

    public void create(int width, int height, int[][] pixesl) {
        gYrez = new int[width][height];
        gY= new int[width][height];
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

                    int gradientY = ((1 * val00) + (2 * val01) + (1 * val02)) + ((0 * val10) + (0 * val11) + (0 * val12))
                            + ((-1 * val20) + (-2 * val21) + (-1 * val22));


                    if(gradientY>max){
                        max=gradientY;
                    }

                    gYrez[i][j]=gradientY;

                }


            }

        }

        formula=(float)max/(float)255;

        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                gY[i][j]=Math.abs((int)((float)gYrez[i][j]/formula));

            }
        }
    }

}
