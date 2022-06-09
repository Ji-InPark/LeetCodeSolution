class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 1;
        
        for(int num : numbers)
        {
            if(map.containsKey(target - num)) return new int[]{map.get(target - num), index};
            
            map.put(num, index++);
        }
        
        return new int[]{0};
    }
}