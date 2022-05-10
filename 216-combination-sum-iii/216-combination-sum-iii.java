class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        
        solve(k, 1, 0, new Stack<Integer>());
        
        return result;
    }
    
    public void solve(int k, int num, int sum, Stack<Integer> s)
    {
        if(sum > n) return;
        
        if(sum == n)
        {
            if(k != 0) return;
            
            result.add(new ArrayList(s));
        }
        
        for(int i = num; i <= 9; i++)
        {
            s.push(i);
            solve(k - 1, i + 1, sum + i, s);
            s.pop();
        }
    }
}