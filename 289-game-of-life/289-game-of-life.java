class Solution {
    public void gameOfLife(int[][] board) {
        int[][] arr = new int[board.length + 2][board[0].length + 2];
        
        int[] xDir = {-1, 0, 1};
        int[] yDir = {-1, 0, 1};
        
        for(int i = 1; i <= board.length; i++)
           for(int j = 1; j <= board[0].length; j++)
           {
               arr[i][j] -= board[i - 1][j -1];
               for(int y : yDir)
                   for(int x : xDir)
                       arr[i + y][j + x] += board[i - 1][j -1];
           }

        for(int i = 1; i <= board.length; i++)
        {
           for(int j = 1; j <= board[0].length; j++)
           {
               int num = arr[i][j];
               
               if(board[i - 1][j - 1] == 0)
               {
                   if(num == 3) board[i - 1][j - 1] = 1;
               }
               else
               {
                   if(num < 2 || 3 < num) board[i - 1][j - 1] = 0;
               }
           }
        }
    }
}