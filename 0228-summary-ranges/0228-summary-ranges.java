class Solution {
    public List<String> summaryRanges(int[] nums) {
        var result = new ArrayList<String>();
        if(nums.length == 0) return result;
        
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] == 1) continue;
            
            var range = prev == nums[i - 1] ? Integer.toString(prev) : prev + "->" + nums[i - 1];
            result.add(range);
            
            prev = nums[i];
        }
        
        var range = prev == nums[nums.length - 1] 
            ? Integer.toString(prev) 
            : prev + "->" + nums[nums.length - 1];
        result.add(range);
        
        return result;
    }
}