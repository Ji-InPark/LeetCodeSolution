class Solution {
    int[][] arr;
    boolean[][] visit;
    int[] diry = {1, 0, -1, 0};
    int[] dirx = {0, 1, 0, -1};
    
    int sum = 0, result = 0;
    public int maxAreaOfIsland(int[][] grid) {
        arr = grid;
        visit = new boolean[grid.length][grid[0].length];
        
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[0].length; x++) {
                sum = 0;
                if(!visit[y][x] && arr[y][x] == 1) solve(x, y);
                result = Math.max(sum, result);
            }
        }
        return result;
    }
    
    public void solve(int x, int y) {
        if(y < 0 || arr.length <= y || x < 0 || arr[0].length <= x) return;
        
        if(visit[y][x]) return;
        
        if(arr[y][x] == 0) return;
        
        visit[y][x] = true;
        sum++;
        
        for(int i = 0; i < 4; i++) {
            solve(x + dirx[i], y + diry[i]);
        }
    }
}