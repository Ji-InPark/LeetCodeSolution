class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m + 1][n + 1];
        arr[1][1] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        
        boolean[][] v = new boolean[m + 1][n + 1];
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                Point now = q.poll();
                
                if(v[now.y][now.x]) continue;
                
                if(now.x + 1 <= n && now.y <= m) {
                    arr[now.y][now.x + 1] += arr[now.y][now.x];
                    q.add(new Point(now.x + 1, now.y));
                }
                
                if(now.x <= n && now.y + 1 <= m) {
                    arr[now.y + 1][now.x] += arr[now.y][now.x];
                    q.add(new Point(now.x, now.y + 1));
                }
                
                v[now.y][now.x] = true;
            }
        }
        
        return arr[m][n];
    }
    
    class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}