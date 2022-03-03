class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;        
        int result = 0, sum = 0;
        for(int i = 1; i < nums.length - 1; i++)
        {
            if(nums[i + 1] - nums[i] == nums[i] - nums[i - 1])
                result += ++sum;
            else
                sum = 0;
        }
        return result;
    }

}