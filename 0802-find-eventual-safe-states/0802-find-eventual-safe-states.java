class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;
        
        int nodeCount = graph.length;
        var isSafe = new Boolean[nodeCount];
        
        for(int i = 0;i < nodeCount;i++){
            if(dfs(graph, i, isSafe))    res.add(i);
        }
        
        return res;
    }
    public boolean dfs(int[][] graph, int start, Boolean[] isSafe){
        if(isSafe[start] != null)   return isSafe[start];
        
        isSafe[start] = false;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, isSafe))    return false;
        }
        isSafe[start] = true;
        
        return true;
    }
}