class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 0, new Stack<>());
        
        return result;
    }
    
    private void dfs(int n, int k, int prev, Stack<Integer> s) {
        if(k == 0) {
            result.add(new ArrayList<>(s));
            return;
        }
        
        for(int i = prev + 1; i <= n; i++) {
            s.push(i);
            dfs(n, k - 1, i, s);
            s.pop();
        }
    }
}