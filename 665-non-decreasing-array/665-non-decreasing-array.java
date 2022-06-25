class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 2) return true;
        
        boolean flag = false;
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i - 1] > nums[i])
            {
                if(i == nums.length - 1) return true;
                
                if(nums[i - 1] < nums[i + 1])
                {
                    nums[i] = nums[i - 1];
                }
                else
                {
                    nums[i - 1] = nums[i];
                }
                break;
            }
        }
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i - 1] > nums[i])
            {
                return false;
            }
        }
        
        return true;
    }
}