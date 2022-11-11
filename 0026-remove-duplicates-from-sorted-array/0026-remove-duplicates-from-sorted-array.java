class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = -1000, index = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(pre == nums[i]) continue;
            nums[index++] = nums[i];
            pre = nums[i];
        }
        
        return index;
    }
}