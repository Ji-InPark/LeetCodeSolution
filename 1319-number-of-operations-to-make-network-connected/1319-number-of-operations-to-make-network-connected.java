class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        
        var sets = new boolean[n];
        var arr = setUnion(n, connections);
        int result = -1;
        
        for(var num : arr) {
            if(sets[num]) continue;
            
            result++;
            sets[num] = true;
        }
        
        return result;
    }
    
    private int[] setUnion(int n, int[][] connections) {
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++) arr[i] = i;
        
        for(var connection : connections) {
            int a = findUnion(arr, connection[0]);
            int b = findUnion(arr, connection[1]);
            
            if(a < b) arr[b] = a;
            else arr[a] = b;
        }
        
        for(int i = 0; i < arr.length; i++) findUnion(arr, i);
        
        return arr;
    }
    
    private int findUnion(int[] arr, int n) {
        if(arr[n] == n) return n;
        
        return arr[n] = findUnion(arr, arr[n]);
    }
}