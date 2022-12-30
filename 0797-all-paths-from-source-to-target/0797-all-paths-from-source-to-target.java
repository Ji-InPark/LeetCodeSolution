class Solution {
    int n;
    int[][] g;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = g.length;
        solve(0, new Stack<Integer>());
        return result;
    }
    
    public void solve(int index, Stack<Integer> s) {
        s.push(index);
        
        if(index == n - 1) {
            result.add(new ArrayList<Integer>(s));
            s.pop();
            return;
        }
        
        for(var num: g[index]) {
            solve(num, s);
        }
        
        s.pop();
    }
}