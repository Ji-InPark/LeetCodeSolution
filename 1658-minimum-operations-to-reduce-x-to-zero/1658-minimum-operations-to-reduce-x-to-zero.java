class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(0, 0);
        
        for(int i = 1; i <= nums.length; i++)
        {
            sum += nums[nums.length - i];
            map.put(sum, i);
        }
        
        int result = 1000000;
        
        sum = 0;
        
        if(map.containsKey(x)) result = map.get(x);
            
        for(int i = 0; i < nums.length; i++)
        {
            if(i > result) break;
            
            sum += nums[i];
            
            if(map.containsKey(x - sum) && i + 1 + map.get(x - sum) <= nums.length) result = Math.min(result, i + 1 + map.get(x - sum));
        }
        
        return result == 1000000 ? -1 : result;
    }
}