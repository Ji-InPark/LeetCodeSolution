class Solution {
    public int maximumDetonation(int[][] bombs) {
        var set = new HashSet<Integer>();
        int result = 0;
        
        for(int i = 0; i < bombs.length; i++) {
            if(set.contains(i)) continue;
            
            var dfsSet = dfs(bombs, new HashSet<>(), i);
            
            result = Math.max(result, dfsSet.size());
            
            set.addAll(dfsSet);
        }
        
        return result;
    }
    
    private HashSet<Integer> dfs(int[][] bombs, HashSet<Integer> set, int now) {
        set.add(now);
        
        for(int i = 0; i < bombs.length; i++) {
            if(set.contains(i)) continue;
            
            var a = bombs[now];
            var b = bombs[i];
            
            long length = a[2], x = Math.abs(a[0] - b[0]), y = Math.abs(a[1] - b[1]);
            
            if(length * length >= x * x + y * y) dfs(bombs, set, i);
        }
        
        return set;
    }
}