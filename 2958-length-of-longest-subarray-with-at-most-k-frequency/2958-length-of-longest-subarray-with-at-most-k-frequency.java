class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int result = 0, index = 0;
        
        for(int i = 0; i < nums.length; i++) {
            var num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if(map.get(num) > k) {
                while(nums[index] != num) {
                    var value = nums[index++];
                    map.put(value, map.get(value) - 1);    
                }
                
                map.put(num, map.get(num) - 1);
                index++;
            }
            
            result = Math.max(result, i - index + 1);
        }
        
        return result;
    }
}