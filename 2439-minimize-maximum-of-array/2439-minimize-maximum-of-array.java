class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = 0;
        
        for(int i = 0; i< nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum / (i + 1) + (sum % (i + 1) > 0 ? 1 : 0));
        }
        
        return (int)max;
    }
}