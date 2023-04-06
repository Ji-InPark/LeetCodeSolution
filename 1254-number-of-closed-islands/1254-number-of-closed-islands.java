class Solution {
    public int closedIsland(int[][] grid) {
        int c = grid.length, r = grid[0].length, result = 0;
        var dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        var visit = new boolean[c][r];
        
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                if(visit[i][j] || grid[i][j] == 1) continue;
                
                var isIsland = true;
                var q = new LinkedList<int[]>();
                q.add(new int[]{i, j});
                while(!q.isEmpty()) {
                    var now = q.poll();
                    if(now[0] < 0 || now[0] >= c || now[1] < 0 || now[1] >= r) continue;
                    if(visit[now[0]][now[1]] || grid[now[0]][now[1]] == 1) continue;
                    if(now[0] == 0 || now[0] == c - 1 || now[1] == 0 || now[1] == r - 1) isIsland = false;
                    
                    visit[now[0]][now[1]] = true;
                    
                    for(var d : dir) q.add(new int[]{now[0] + d[0], now[1] + d[1]});
                }
                
                if(isIsland) result++;
            }
        }
        
        return result;
    }
}