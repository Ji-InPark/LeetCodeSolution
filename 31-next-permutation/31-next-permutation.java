class Solution {
    public void nextPermutation(int[] nums) {
        int lastIndex = -1; 
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] < nums[i + 1]) lastIndex = i;
        }
        
        if(lastIndex == -1)
        {
            Arrays.sort(nums);
        }
        else
        {
            int minIndex = lastIndex + 1;
            for(int i = lastIndex + 1; i < nums.length; i++)
            {
                if(nums[lastIndex] < nums[i] && nums[i] < nums[minIndex]) minIndex = i;
            }
            
            int temp = nums[minIndex];
            nums[minIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            
            Arrays.sort(nums, lastIndex + 1, nums.length);
        }
    }
}