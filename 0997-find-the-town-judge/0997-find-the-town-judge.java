class Solution {
    public int findJudge(int n, int[][] trust) {
        var arr = new int[n + 1];
        for(var t : trust) {
            arr[t[0]] = -1;
            arr[t[1]]++;
        }
        
        for(int i = 1; i <= n; i++) if(arr[i] == n - 1) return i;
        
        return -1;
    }
}