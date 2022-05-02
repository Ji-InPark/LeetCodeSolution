class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int right = nums.length - 1;
        
        for(int left = 0 ; left < right; left++)
        {
            while(left < right && nums[right] % 2 == 1) right--;
            
            if(nums[left] % 2 == 1) 
            {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
                right--;
            }
        }
        
        return nums;
    }
}