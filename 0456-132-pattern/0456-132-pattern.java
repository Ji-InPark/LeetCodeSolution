class Solution {
    public boolean find132pattern(int[] nums) {
        var map = new TreeMap<Integer, Integer>();
        
        for(var num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int min = nums[0], max = nums[0];
        
        for(var num: nums) {
            if(num > max) max = num;
            
            if(num < min) {
                max = num;
                min = num;
            }
            
            map.put(num, map.get(num) - 1);
            if(map.get(num) == 0) map.remove(num);
            
            var floor = map.floorKey(max - 1);
            
            if(floor != null && min < floor) return true;
        }
        
        return false;
    }
}