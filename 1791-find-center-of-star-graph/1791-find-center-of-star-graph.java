class Solution {
    public int findCenter(int[][] edges) {
        var n = edges.length;
        var count = new int[n + 2];
        
        for(var edge: edges) {
            if(++count[edge[0]] == n) return edge[0];
            if(++count[edge[1]] == n) return edge[1];
        }
        
        return 0;
    }
}