class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int[] m: matches) {
            map.put(m[0], map.getOrDefault(m[0], 0));
            map.put(m[1], map.getOrDefault(m[1], 0) + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        
        for(var set: map.entrySet()) {
            if(set.getValue() == 0) {
                r1.add(set.getKey());
            } else if(set.getValue() == 1) {
                r2.add(set.getKey());
            }
        }
        
        Collections.sort(r1);
        Collections.sort(r2);
        
        result.add(r1);
        result.add(r2);
        
        return result;
    }
}