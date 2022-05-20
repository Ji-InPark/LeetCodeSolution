class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[arr.length - 1][arr[0].length - 1] == 1) return 0;
        
        int[] dp = new int[arr[0].length];
        dp[0] = 1;
        
        for(int[] row : arr)
        {
            for(int j = 0; j < row.length; j++)
            {
                if(row[j] == 1)
                    dp[j] = 0;
                else if(j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        
        return dp[arr[0].length - 1];
    }
}