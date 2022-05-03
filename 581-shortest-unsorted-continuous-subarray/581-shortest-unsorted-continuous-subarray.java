class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        
        Arrays.sort(sorted);
        
        int left = 100000, right = -1;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != sorted[i])
            {
                left = i;
                break;
            }
        }
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] != sorted[i])
            {
                right = i;
                break;
            }
        }
        
        if(right <= left) return 0;
        
        return right - left + 1;
    }
}