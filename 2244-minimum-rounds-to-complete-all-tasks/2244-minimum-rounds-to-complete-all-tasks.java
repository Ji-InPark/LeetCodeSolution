class Solution {
    public int minimumRounds(int[] tasks) {
        var map = new HashMap<Integer, Integer>();
        var result = 0;
        
        for(var task: tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        
        for(var value: map.values()) {
            if(value == 1) return -1;
            result += (value + 2) / 3;
        }   
        
        return result;
    }
}

