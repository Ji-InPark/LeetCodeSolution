class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10005];
        int[] dp = new int[10005];
        
        for(int num : nums)
        {
            arr[num] += num;   
        }
        
        dp[1] = dp[2] = arr[1];
        
        for(int i = 2; i <= 10000; i++)
        {
            if(dp[i - 2] + arr[i] > dp[i])
            {
                dp[i] = dp[i - 2] + arr[i];
            }
            dp[i + 1] = dp[i];
        }
        
        return dp[10000];
    }
}