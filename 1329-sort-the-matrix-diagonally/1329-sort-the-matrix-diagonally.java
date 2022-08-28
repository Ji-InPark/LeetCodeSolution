class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Queue<Point> q = new LinkedList<>();
        int r = mat[0].length, c = mat.length;
        pq.add(new Point(r - 1, 0, mat[0][r - 1]));
        q.add(new Point(r - 1, 0, mat[0][r - 1]));
        
        int[][] result = new int[c][r];
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size - 1; i++) {
                Point qnow = q.poll(), pqnow = pq.poll();
                
                result[qnow.y][qnow.x] = pqnow.value;
                
                if(qnow.x - 1 >= 0) {
                    q.add(new Point(qnow.x - 1, qnow.y, mat[qnow.y][qnow.x - 1]));
                }
            }
            
            Point qnow = q.poll(), pqnow = pq.poll();
            
            result[qnow.y][qnow.x] = pqnow.value;

            if(qnow.x - 1 >= 0) {
                q.add(new Point(qnow.x - 1, qnow.y, mat[qnow.y][qnow.x - 1]));
            }
            
            if(qnow.y + 1 < c) {
                q.add(new Point(qnow.x, qnow.y + 1, mat[qnow.y + 1][qnow.x]));
            }
            
            size = q.size();
            for(int i = 0; i < size; i++){
                Point p = q.poll();
                pq.add(p);
                q.add(p);
            }
        }
        
        return result;
    }
    
    class Point implements Comparable<Point>{
        int x, y, value;
        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
        @Override
        public int compareTo(Point p) {
            return this.value - p.value;
        }
    }
}