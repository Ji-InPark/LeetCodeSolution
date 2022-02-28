class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int first = -1, last = -1;
        boolean flag = true;
        if(nums.length == 0)
        {
            return result;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(flag)
            {
                first = nums[i];
                last = nums[i];
                flag = false;
                continue;
            }
            
            if(nums[i] - 1 == nums[i - 1])
            {
                last = nums[i];
            }
            else
            {
                if(first == last)
                {
                    result.add(Integer.toString(first));
                }
                else
                {
                    result.add(first + "->" + last);
                }
                
                flag = true;
                i--;
            }
        }
        
        if(first == last)
        {
            result.add(Integer.toString(first));
        }
        else
        {
            result.add(first + "->" + last);
        }
        
        return result;
    }
}