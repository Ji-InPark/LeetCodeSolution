class Solution {
    int n, k;
    HashSet<Integer> set = new HashSet<>();
    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        
        for(int i = 1; i < 10; i++) {
            dfs(String.valueOf(i), i);
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for(int num : set) {
            result[index++] = num;
        }
        
        return result;
    }
    
    public void dfs(String str, int pre) {
        if(str.length() == n) {
            set.add(Integer.parseInt(str));
            return;
        }
        
        if(pre + k <= 9) {
            dfs(str + String.valueOf(pre + k), pre + k);
        }
        if(pre - k >= 0) {
            dfs(str + String.valueOf(pre - k), pre - k);
        }
    }
}