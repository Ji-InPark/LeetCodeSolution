class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;
        
        int result = 0;
        int first = 0, last = -1;
        int diff = nums[0] - nums[1];
        
        for(int i = 1; i < nums.length - 1; i++)
        {
            if(nums[i] - nums[i + 1] != diff)
            {
                if(last - first + 1 >= 3)
                {
                    result += calc(last - first + 1);
                }
                    
                first = i;
                last = i + 1;
                diff = nums[i] - nums[i + 1];
            }
            else
            {
                last = i + 1;
            }
        }
        
        if(last - first + 1 >= 3)
        {
            result += calc(last - first + 1);
        }
        
        return result;
    }
    
    public int calc(int num)
    {
        int result = 0;
        for(int i = 3; i <= num; i++)
        {
            result += num + 1 - i;
        }
        return result;
    }
}