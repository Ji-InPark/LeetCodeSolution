class Solution {
    public int minScore(int n, int[][] roads) {
        int[] arr = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) arr[i] = i;
        
        for(var road : roads) {
            int a = findUnion(arr, road[0]);
            int b = findUnion(arr, road[1]);
            
            if(a < b) arr[b] = a;
            else arr[a] = b;
        }
        
        int result = Integer.MAX_VALUE;
        
        for(var road : roads) {
            if(findUnion(arr, road[0]) == 1) result = Math.min(result, road[2]);
        }
        
        return result;
    }
    
    private int findUnion(int[] arr, int n) {
        if(arr[n] == n) return n;
        
        return findUnion(arr, arr[n]);
    }
}