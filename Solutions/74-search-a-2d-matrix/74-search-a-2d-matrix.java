class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1, mid, mod = matrix[0].length;
        
        while(left <= right)
        {
            mid = (left + right) / 2;
            
            int y = mid / mod, x = mid % mod;
            
            if(matrix[y][x] == target)
            {
                return true;
            }
            else if(matrix[y][x] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return false;
    }
}