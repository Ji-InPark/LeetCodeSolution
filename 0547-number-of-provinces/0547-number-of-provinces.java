class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        var arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    int a = find(arr, i), b = find(arr, j);
                    
                    if(a < b) arr[b] = a;
                    else arr[a] = b;
                }
            }
        }
        
        var set = new HashSet<Integer>();
        for(int i = 0; i < n; i++) set.add(find(arr, i));
        
        return set.size();
    }
    
    private int find(int[] arr, int n) {
        if(arr[n] == n) return n;
        
        return arr[n] = find(arr, arr[n]);
    }
}