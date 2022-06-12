class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] used = new boolean[100005];
        int left = 0, sum = 0, result = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            while(used[nums[i]])
            {
                sum -= nums[left];
                used[nums[left++]] = false;
            }
            
            used[nums[i]] = true;
            sum += nums[i];
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
}