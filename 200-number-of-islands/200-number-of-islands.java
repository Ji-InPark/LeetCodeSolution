class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] arr;
    boolean[][] visit;
    public int numIslands(char[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        arr = grid;
        int result = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(!visit[i][j] && grid[i][j] == '1')
                {
                    dfs(j, i);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public void dfs(int x, int y)
    {
        try
        {
            if(visit[y][x] || arr[y][x] == '0')
                return;
            visit[y][x] = true;
        }
        catch(Exception e)
        {
            return;
        }
        
        for(int i = 0; i < dir.length; i++)
        {
            dfs(x + dir[i][0], y + dir[i][1]);
        }
    }
}