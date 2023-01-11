class Solution {
    boolean[] v;
    boolean[] visit;
    HashMap<Integer, ArrayList<Integer>> map;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        map = new HashMap<>();
        v = new boolean[n];
        visit = new boolean[n];
        
        for(var e : edges) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            if(!map.containsKey(e[1])) map.put(e[1], new ArrayList<>());
            
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        v[0] = true;
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            var apple = hasApple.get(i);
            
            if(!apple) continue;
            
            int length = dfs(i, 0);
            v[i] = true;
            
            if(length > 0) result += length * 2;
        }
        
        return result;
    }
    
    public int dfs(int root, int length) {
        if(v[root]) return length;
        if(visit[root]) return -1;
        
        visit[root] = true;
        
        for(var child: map.get(root)) {
            var l = dfs(child, length + 1);
            if(l > 0) {
                v[child] = true;
                visit[root] = false;
                return l;
            }
        }
        
        visit[root] = false;
        
        return -1;
    }
}