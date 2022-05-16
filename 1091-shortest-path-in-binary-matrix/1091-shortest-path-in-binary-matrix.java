class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        
        int[] xdir = {1, 0, -1, 1, 0, -1, 1, 0, -1};
        int[] ydir = {1, 1, 1, 0, 0, 0, -1, -1, -1};
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        
        Queue<point> q = new LinkedList<>();
        q.add(new point(0, 0));
        
        int result = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            result++;
            
            for(int i = 0; i < size; i++)
            {
                point now = q.poll();
                
                if(visit[now.y][now.x]) continue;
                
                visit[now.y][now.x] = true;
                
                if(now.y == grid.length - 1 && now.x == grid[0].length - 1) return result;
                
                for(int y : ydir)
                {
                    for(int x : xdir)
                    {
                        int tempy = y + now.y;
                        int tempx = x + now.x;
                        
                        if(0 <= tempy && tempy < grid.length)
                            if(0 <= tempx && tempx < grid[0].length)
                                if(grid[tempy][tempx] == 0)
                                    q.add(new point(tempx, tempy));
                        
                    }
                }
            }
        }
        
        return -1;
    }
    
    class point{
        int x, y;
        
        public point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}