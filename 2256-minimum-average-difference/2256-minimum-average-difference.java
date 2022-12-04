class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length, index = 0;
        long sum1 = 0, sum2 = 0, result = Long.MAX_VALUE;
        
        for(var num: nums) sum2 += num;
        
        if(sum2 == 0) return 0;
        
        for(int i = 0; i < n; i++) {
            sum1 += nums[i];
            sum2 -= nums[i];
            
            long temp = Math.abs(sum1 / (i + 1) - (sum2 == 0 ? 0 : (sum2 / (n - i - 1))));
            
            if(result > temp) {
                result = temp;
                index = i;
            }
        }
        
        return index;
    }
}