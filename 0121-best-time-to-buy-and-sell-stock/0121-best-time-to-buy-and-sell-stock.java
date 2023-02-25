class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], result = 0;
        for(var p : prices) {
            min = Math.min(min, p);
            result = Math.max(result, p - min);
        }
        
        return result < 0 ? 0 : result;
    }
}