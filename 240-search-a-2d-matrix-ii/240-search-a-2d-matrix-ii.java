class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int b = 0, t = matrix.length - 1;
        
        while(b < t) {
            int mid = (b + t) / 2;
            
            if(matrix[mid][0] > target) {
                t = mid;
            } else {
                b = mid + 1;
            }
        }
        
        
        for(int i = 0; i <= t; i++) {
            int l = 0, r = matrix[0].length - 1;
            while(l <= r) {
                int mid = (l + r) / 2;
                
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] > target) r = mid - 1;
                else l = mid + 1;
            }
        }
        
        return false;
    }
}