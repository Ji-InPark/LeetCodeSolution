class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length, sum = 0;
        var arr = new int[n + 1];
        
        Arrays.sort(satisfaction);
        
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + satisfaction[i - 1];
            sum += satisfaction[i - 1] * i;
        }
        
        int result = Math.max(0, sum);
        
        for(int i = 0; i <= n; i++) {
            sum -= arr[n] - arr[i];
            result = Math.max(sum, result);
        }
        
        return result;
    }
}