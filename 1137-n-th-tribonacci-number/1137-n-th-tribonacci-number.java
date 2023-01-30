class Solution {
    static int[] arr = new int[38];
    
    public Solution() {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
    }
    
    public int tribonacci(int n) {
        for(int i = 3; i <= n && arr[n] == 0; i++) arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        return arr[n];
    }
}