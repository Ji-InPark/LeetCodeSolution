class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int x_length = matrix[0].length, y_length = matrix.length;
        int nums = x_length * y_length;
        int index = 0;
        
        List<Integer> result = new ArrayList<Integer>();
        
        int x = 0, y = 0;
        
        while(nums > 0)
        {
            try
            {
                if(matrix[y][x] == -1000)
                    throw new Exception("test");
                
                result.add(matrix[y][x]);
                matrix[y][x] = -1000;
                
                
                nums--;
                
                x += dir[index][0];
                y += dir[index][1];
            }
            catch(Exception e)
            {
                x -= dir[index][0];
                y -= dir[index][1];
                
                index++;
                index %= 4;
                
                x += dir[index][0];
                y += dir[index][1];
            }
        }
        
        return result;
    }
}