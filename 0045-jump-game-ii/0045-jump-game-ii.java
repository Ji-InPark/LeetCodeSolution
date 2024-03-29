class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        var arr = new int[n];
        
        if(n == 1) return 0;
        
        for(int i = 0; i < n; i++) {
            if(i + nums[i] >= n - 1) return arr[i] + 1;
            
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(arr[j] > arr[i] || arr[j] == 0) arr[j] = arr[i] + 1;
            }
        }
        
        return 0;
    }
}