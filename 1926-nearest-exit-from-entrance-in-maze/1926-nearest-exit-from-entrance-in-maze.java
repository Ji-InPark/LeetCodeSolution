class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int col = maze.length, row = maze[0].length;
        int result = 0;
        int[][] dir = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        maze[entrance[0]][entrance[1]] = '+';
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int[] now = q.poll();
                int x = now[1], y = now[0];
                
                if(x == 0 || y == 0 || x == row - 1 || y == col - 1) {
                    if(maze[y][x] == '-') return result;
                }
                
                for(int[] d : dir) {
                    int nx = x + d[1], ny = y + d[0];
                    
                    if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                    
                    if(maze[ny][nx] != '.') continue;
                    
                    maze[ny][nx] = '-';
                    
                    q.add(new int[]{ny, nx});
                }
            }
            
            result++;
        }
        
        return -1;
    }
}