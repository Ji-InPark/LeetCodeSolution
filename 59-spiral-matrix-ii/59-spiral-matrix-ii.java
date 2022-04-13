class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        int index = 0, yIndex = 0, xIndex = 0;
        int i = 1;
        
        while(i <= n * n)
        {
            try
            {
                if(result[yIndex][xIndex] > 0) throw new Exception("");
                
                result[yIndex][xIndex] = i++;
                
                xIndex += x[index];
                yIndex += y[index];
            }
            catch(Exception e)
            {
                xIndex -= x[index];
                yIndex -= y[index];
                
                index++;
                index %= 4;
                
                xIndex += x[index];
                yIndex += y[index];
            }
        }
        
        return result;
    }
}