class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, mi = n - 1, sum = 0;
        
        for(int i = 0; i < n; i++) 
            sum += mat[i][i] + mat[mi - i][i];
        
        return sum - (n % 2 == 1 ? mat[n / 2][n / 2] : 0);
    }
}