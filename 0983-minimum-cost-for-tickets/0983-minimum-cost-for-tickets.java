class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        var set = new HashSet<Integer>();
        for(var day: days) set.add(day);
        int n = days.length;
        var ranges = new int[] {1, 7, 30};
        var dp = new int[days[n - 1] + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int pre = 0;
        
        for(int day = 0; day < dp.length; day++) {
            for(int j = 0; j < 3; j++) {
                int beforeDay = Math.max(day - ranges[j], 0), cost = costs[j];
                
                if(!set.contains(day) || pre > day) {
                    dp[day] = dp[pre];
                    continue;
                }
                
                pre = day;
                
                dp[day] = Math.min(dp[beforeDay] + cost, dp[day]);
            }
        }
        
        return dp[days[n - 1]];
    }
}