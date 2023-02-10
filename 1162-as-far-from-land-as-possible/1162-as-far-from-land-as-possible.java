class Solution {
    public int maxDistance(int[][] grid) {
        var dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int c = grid.length, r = grid[0].length;
        var q = new LinkedList<int[]>();
        
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                if(grid[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        
        if(q.size() == r * c) return -1;
        
        int result = -1;
        for(;!q.isEmpty(); result++) {
            int size = q.size(); 
            for(int i = 0; i < size; i++) {
                var now = q.poll();
                
                for(var d : dir){
                    int nowC = d[0] + now[0], nowR = d[1] + now[1];
                    
                    if(nowC < 0 || nowC >= c || nowR < 0 || nowR >= r || grid[nowC][nowR] == 1) continue;
                    
                    q.add(new int[] {nowC, nowR});
                    grid[nowC][nowR] = 1;
                }
            }
        }
        
        return result;
    }
}