class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, result = 0;
        var lArr = new int[n];
        var rArr = new int[n];
        
        for(int i = 1; i < n; i++) {
            lArr[i] = (lArr[i - 1] + 1) * nums[i - 1];
            rArr[n - i - 1] = (rArr[n - i] + 1) * nums[n - i];
        }
        
        for(int i = 0; i < n; i++) result = Math.max(result, lArr[i] + rArr[i]);
        
        return result;
    }
}