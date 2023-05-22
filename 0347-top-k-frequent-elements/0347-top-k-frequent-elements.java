class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        var map = new HashMap<Integer, LinkedList<Integer>>();
        int maxFrequent = 0;
        
        for(var num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            maxFrequent = Math.max(maxFrequent, freqMap.get(num));
            
            if(!map.containsKey(freqMap.get(num))) map.put(freqMap.get(num), new LinkedList<>());
            
            map.get(freqMap.get(num)).add(num);
        }
        
        var result = new int[k];
        var set = new HashSet<Integer>();
        
        while(set.size() < k) {
            if(map.get(maxFrequent).isEmpty()) maxFrequent--;
            set.add(map.get(maxFrequent).poll());
        }
        
        int index = 0;
        for(var num: set) result[index++] = num;
        
        return result;
    }
}