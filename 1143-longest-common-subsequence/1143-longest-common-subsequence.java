class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[2][1001];
        var a = text1.toCharArray();
        var b = text2.toCharArray();
        
        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < b.length; j++)
                dp[(i % 2 != 0) ? 0 : 1][j + 1] = a[i] == b[j] ? dp[(i % 2 == 0) ? 0 : 1][j] + 1 : Math.max(dp[(i % 2 == 0) ? 0 : 1][j + 1], dp[(i % 2 != 0) ? 0 : 1][j]);
        
        return dp[a.length % 2 == 0 ? 0 : 1][b.length];
    }
}