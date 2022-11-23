class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] v = new boolean[10][10];
        for(int i = 0; i < 9; i++) {
            boolean[] v1 = new boolean[10];
            boolean[] v2 = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(v1[board[i][j] - '0']) return false;
                    v1[board[i][j] - '0'] = true;
                }
                if(board[j][i] != '.') {
                    if(v2[board[j][i] - '0']) return false;
                    v2[board[j][i] - '0'] = true;
                }
                if(board[i][j] != '.') {
                    int index = (i / 3) * 3 + (j / 3), num = board[i][j] - '0';
                    if(v[index][num]) return false;
                    v[index][num] = true;
                }
            }
        }
        
        return true;
    }
}