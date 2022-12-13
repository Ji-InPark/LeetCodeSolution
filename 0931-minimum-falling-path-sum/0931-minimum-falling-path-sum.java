class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int c = matrix.length, r = matrix[0].length;
        for(int i = 1; i < c; i++) {
            for(int j = 0; j < r; j++) {
                int num = Integer.MAX_VALUE;
                for(int k = -1; k <= 1; k++) {
                    if(0 <= j + k && j + k < r) num = Math.min(num, matrix[i][j] + matrix[i - 1][j + k]);
                }
                matrix[i][j] = num;
            }
        }
        
        int result = matrix[c - 1][0];
        for(int i = 1; i < r; i++) result = Math.min(result, matrix[c - 1][i]);
        
        return result;
    }
}