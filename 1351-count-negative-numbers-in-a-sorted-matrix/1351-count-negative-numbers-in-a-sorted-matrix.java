class Solution {
    public int countNegatives(int[][] grid) {
        int y = 0, result = 0;
        for(int x = grid[0].length - 1; x >= 0; x--) {
            while(y < grid.length && grid[y][x] >= 0) y++;
            
            if(y > grid.length) break;
            
            result += grid.length - y;
        }
        
        return result;
    }
}