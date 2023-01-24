class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, index = 1;
        var arr = new int[n * n + 1];
        var v = new boolean[n * n + 1];
        var flag = true;
        
        for(int i = n - 1; i >= 0; i--) {
            if(flag) for(int j = 0; j < n; j++) arr[index++] = board[i][j];
            else for(int j = n - 1; j >= 0; j--) arr[index++] =  board[i][j];
            flag = !flag;
        }
        
        int steps = 0;
        var q = new LinkedList<Integer>();
        q.add(arr[1] == -1 ? 1 : arr[1]);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int now = q.poll();
                if(v[now]) continue;
                v[now] = true;
                
                if(now == n * n) return steps;
                
                for(int j = now + 1; j <= Math.min(now + 6, n * n); j++) q.add(arr[j] == -1 ? j : arr[j]);
            }
            steps++;
        }
        
        return -1;
    }
}