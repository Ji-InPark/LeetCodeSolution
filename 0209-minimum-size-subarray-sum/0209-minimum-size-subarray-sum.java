class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1, left = 0, sum = 0; 
        for(int i = 0; i< nums.length; i++) {
            sum += nums[i];
            while(sum >= target && left <= i) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left++];
            }
        }
        
        return result == (nums.length + 1) ? 0 : result;
    }
}