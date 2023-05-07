class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isUp = true, isDown = true;
        for(int i = 1; i < nums.length && isUp; i++) if(nums[i - 1] > nums[i]) isUp = false;
        for(int i = 1; i < nums.length && isDown; i++) if(nums[i - 1] < nums[i]) isDown = false;
        return isUp || isDown;
    }
}