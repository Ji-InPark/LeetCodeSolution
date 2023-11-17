class Solution {
    public int minPairSum(int[] nums) {
        int length = nums.length, max = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < length / 2; i++) 
            max = Math.max(max, nums[i] + nums[length - 1 - i]);
        
        return max;
    }
}