class Solution {
    public int numTilings(int n) {
        var dp = new int[n + 4];
        var mod = 1000000007;
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        for(int i = 4; i <= n; i++) dp[i] = ((2 * dp[i - 1]) % mod + dp[i - 3]) % mod;
        
        return dp[n];
    }
}