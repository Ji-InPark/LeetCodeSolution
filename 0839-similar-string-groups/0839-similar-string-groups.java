class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    String[] strs;
    public int numSimilarGroups(String[] strs) {
        this.strs = strs;
        
        for(int i = 0; i < strs.length; i++) {
            map.put(strs[i], Math.min(i, map.getOrDefault(strs[i], 1000)));
            solve(strs[i], map.get(strs[i]));
        }
        
        var set = new HashSet<Integer>();
        
        for(var str: strs) set.add(map.get(str));
        
        return set.size();
    }
    
    private void solve(String str1, int count) {
        for(var str2: strs) {
            if(map.containsKey(str2)) continue;
            
            var arr1 = str1.toCharArray();
            var arr2 = str2.toCharArray();
            
            int diff = 0;
            for(int i = 0; i < arr1.length && diff <= 2; i++) {
                if(arr1[i] != arr2[i]) diff++;
            }
            
            if(diff == 2) {
                map.put(str2, count);
                solve(str2, count);
            }
        }
    }
}