class Solution {
    boolean[] visit;
    
    public int longestCycle(int[] edges) {
        visit = new boolean[edges.length];
        int result = -1;
        
        for(var edge : edges) {
            var node = findCycle(edges, new HashSet<>(), edge);
            
            if(node < 0) continue;
            
            int temp = edges[node], length = 1;
            
            for(; node != temp; length++) temp = edges[temp];
            
            result = Math.max(result, length);
        }
        
        return result;
    }
    
    public int findCycle(int[] edges, HashSet<Integer> set, int root) {
        if(root < 0) return -1;
        if(!set.add(root)) return root;
        if(visit[root]) return -1;
        
        visit[root] = true;
        
        return findCycle(edges, set, edges[root]);
    }
}