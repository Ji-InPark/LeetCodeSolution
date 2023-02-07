class Solution {
    public int totalFruit(int[] fruits) {
        int result = 0, diff = 0, index = 0, length = 0;
        var map = new HashMap<Integer, Integer>();
        
        for(var f : fruits) {
            map.put(f, map.getOrDefault(f, 0) + 1);
            if(map.get(f) == 1) diff++;
            length++;
            
            while(diff > 2) {
                map.put(fruits[index], map.get(fruits[index]) - 1);
                if(map.get(fruits[index++]) == 0) diff--;
                length--;
            }
            
            result = Math.max(result, length);
        }
        
        return result;
    }
}