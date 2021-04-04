import java.util.ArrayList;
import java.util.List;


public class histogram {
    public int[][] gYrez;
    public int[][] gY8x8;
    public int[][] gXrez;
    public int[][]g;
    public int[][]g8x8;
    public int[][] gX8x8;
    public int willUsingWidth=0;
    public int willUsingHeight=0;
    public int countWidth=0;
    public int countHeight=0;
    public int[] allValue={0,20,40,60,80,100,120,140,160,180};
    public List<Integer[]> histogramCount = new ArrayList<Integer[]>();
    public int max=0;

    public void createHistogram(int width, int height, int[][] pixel){
        willUsingHeight = height-2;
        willUsingWidth = width-2;
        for(int j=0;j<willUsingWidth;j=j+8){
            if((j+7<=willUsingWidth)){
                countWidth++;
            }
        }

        for (int i=0;i<willUsingHeight;i=i+8){
            if((i+7<=willUsingHeight)){
                countHeight++;
            }
        }

        createVerticalEdge createVerticalEdge = new createVerticalEdge();
        createVerticalEdge.create(width,height,pixel);
        gXrez=createVerticalEdge.gX;

        createHorizontalEdge createHorizontalEdge = new createHorizontalEdge();
        createHorizontalEdge.create(width,height,pixel);
        gYrez=createHorizontalEdge.gY;

        createGEdge createGEdge = new createGEdge();
        createGEdge.create(gXrez,gYrez,width,height);
        g=createGEdge.g;

        gX8x8=new int[8][8];
        gY8x8=new int[8][8];
        g8x8=new int[8][8];

        for(int i = 0;i<countWidth;i++){
            for(int j = 0;j<countHeight;j++){
                Integer[] sumFor8x8={0,0,0,0,0,0,0,0,0};
                for(int k=0;k<8;k++){
                    for(int m=0;m<8;m++){
                        int value1=(i*8)+k,value2=(j*8)+m;
                        gX8x8[k][m]=gXrez[value1][value2];
                        gY8x8[k][m]=gYrez[value1][value2];
                        g8x8[k][m]=g[value1][value2];

                    }
                }


                for(int k=0;k<8;k++){
                    for(int m=0;m<8;m++){
                        double rezValue ;
                        if(gX8x8[k][m]==0){
                            rezValue=0.0000001;
                        }else{
                            rezValue=gX8x8[k][m];
                        }
                          double degree = Math.toDegrees((Math.atan(gY8x8[k][m]/rezValue)));
                        for(int count=0;count<9;count++){
                            if(allValue[count]<=degree && degree<=allValue[count+1]){
                                int small=allValue[count];
                                int big=allValue[count+1];
                                int forBig=(int)((degree-small)*100)/20;
                                int forSmall=(int)((big-degree)*100)/20;
                                int index=allValue[count]/20;
                                sumFor8x8[index]+=(g8x8[k][m]*forSmall)/100;
                                sumFor8x8[index+1]+=(g8x8[k][m]*forBig)/100;
                                if(sumFor8x8[index]>max){
                                    max=sumFor8x8[index];
                                }
                                if(sumFor8x8[index+1]>max){
                                    max=sumFor8x8[index+1];
                                }
                            }
                        }


                    }
                }
                histogramCount.add(sumFor8x8);
            }
        }


    }
}
