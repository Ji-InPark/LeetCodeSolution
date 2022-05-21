class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 5];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        
        for(int i = 0; i <= amount; i++)
        {
            if(dp[i] != 100000)
            {
                for(int coin : coins)
                {
                    if(coin > amount - i) continue;
                    
                    dp[i + coin] = Math.min(dp[i] + 1, dp[i + coin]);
                }
            }
        }
        
        return dp[amount] == 100000 ? -1 : dp[amount];
    }
}