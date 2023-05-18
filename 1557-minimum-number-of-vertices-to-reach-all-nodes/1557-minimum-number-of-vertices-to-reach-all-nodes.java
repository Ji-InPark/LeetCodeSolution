class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var arr = new boolean[n];
        
        for(var edge: edges) arr[edge.get(1)] = true;
        
        var result = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++) if(!arr[i]) result.add(i);
        
        return result;
    }
}