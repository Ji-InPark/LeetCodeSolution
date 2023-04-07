class Solution {
    public int numEnclaves(int[][] grid) {
        int result = 0, c = grid.length, r = grid[0].length;
        var dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        var visit = new boolean[c][r];
        
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                if(visit[i][j] || grid[i][j] == 0) continue;
                var flag = true;
                int count = 0;
                var q = new LinkedList<int[]>();
                q.add(new int[]{i, j});
                while(!q.isEmpty()) {
                    var now = q.poll();
                    if(now[0] < 0 || now[0] >= c || now[1] < 0 || now[1] >= r) continue;
                    if(visit[now[0]][now[1]] || grid[now[0]][now[1]] == 0) continue;
                    if(now[0] == 0 || now[0] == c - 1 || now[1] == 0 || now[1] == r - 1) flag = false;
                    
                    visit[now[0]][now[1]] = true;
                    count++;
                    
                    for(var d : dirs) q.add(new int[]{now[0] + d[0], now[1] + d[1]});
                }
                
                if(flag) result += count;
            }
        }
        
        return result;
    }
}