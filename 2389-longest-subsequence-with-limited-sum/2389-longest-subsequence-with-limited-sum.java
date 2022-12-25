class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        var result = new int[queries.length];
        
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        for(int i = 0; i < result.length; i++) {            
            result[i] = find(nums, queries[i]);
        }
        
        return result;
    }
    
    public int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}