class Solution {
    Stack<Character> s = new Stack<>();
    String w;
    boolean[][] v;
    char[][] b;
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        w = word;
        b = board;
        v = new boolean[b.length][b[0].length];
        
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                if(result) break;
                solve(j, i);
            }
        }
        
        return result;
    }
    
    public void solve(int x, int y) {
        if(y < 0 || x < 0 || y >= b.length || x >= b[0].length || result) return;
        
        if(v[y][x]) return;
        
        if(b[y][x] != w.charAt(s.size())) return;
        
        v[y][x] = true;
        
        s.push(b[y][x]);
        
        if(s.size() == w.length()) {
            result = true;
            return;
        }
        
        solve(x + 1, y);
        solve(x, y - 1);
        solve(x - 1, y);
        solve(x, y + 1);
        
        s.pop();
        
        v[y][x] = false;
    }
}