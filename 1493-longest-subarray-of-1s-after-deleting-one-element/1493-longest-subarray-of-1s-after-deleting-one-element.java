class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        var lArr = new int[n];
        var rArr = new int[n];
        
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] == 1) {
                lArr[i] = lArr[i - 1] + 1;
            } else {
                lArr[i] = 0;
            }
            
            if(nums[n - i] == 1) {
                rArr[n - i - 1] = rArr[n - i] + 1;
            } else {
                rArr[n - i - 1] = 0;
            }
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) result = Math.max(result, lArr[i] + rArr[i]);
        
        return result;
    }
}