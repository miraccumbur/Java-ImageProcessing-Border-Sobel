
public class drawingTab6{

    public int[][] createdPixels;

    public void create(int[] valueOfX, int[] valueOfY, int[][] pixels) {
        int firstX = Math.min(valueOfX[0], valueOfX[1]);
        int secondX = Math.max(valueOfX[0], valueOfX[1]);
        int firstY = Math.min(valueOfY[0], valueOfY[1]);
        int secondY = Math.max(valueOfY[0], valueOfY[1]);

        int xLength = (secondX - firstX);
        int yLength = (secondY - firstY);


        createdPixels = new int[xLength * 2][yLength * 2];

        for (int i = firstX, xIndex = 0; i < secondX; i++, xIndex += 2) {
            for (int j = firstY, yIndex = 0; j < secondY; j++, yIndex += 2) {
                createdPixels[xIndex][yIndex] = pixels[i][j];
                createdPixels[xIndex + 1][yIndex] = pixels[i][j];
                createdPixels[xIndex][yIndex + 1] = pixels[i][j];
                createdPixels[xIndex + 1][yIndex + 1] = pixels[i][j];
            }
        }

    }

}