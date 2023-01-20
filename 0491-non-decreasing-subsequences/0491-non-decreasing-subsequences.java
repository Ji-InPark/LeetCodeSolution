class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] arr;
    public List<List<Integer>> findSubsequences(int[] nums) {
        arr = nums;
        
        solve(0, -10000, new Stack<>());
        
        return result;
    }
    
    public void solve(int index, int prev, Stack<Integer> s) {
        if(index == arr.length) {
            if(s.size() > 1) result.add(new ArrayList(s));
            return;
        }
        
        if(prev <= arr[index]) {
            s.push(arr[index]);
            solve(index + 1, arr[index], s);
            s.pop();
        }
        if(prev != arr[index]) solve(index + 1, prev, s);
    }
}