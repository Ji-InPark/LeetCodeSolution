class Solution {
    public int minPathSum(int[][] grid) {
        int c = grid.length, r = grid[0].length;
        for(int i = 0; i < c; i++) {
            for(int j = 0 ; j < r; j++) {
                if(i == 0 && j == 0) continue;
                
                int left = j > 0 ? grid[i][j - 1] : 50000;
                int up = i > 0 ? grid[i - 1][j] : 50000;
                
                grid[i][j] += Math.min(left, up);
            }
        }
        
        return grid[c - 1][r - 1];
    }
}