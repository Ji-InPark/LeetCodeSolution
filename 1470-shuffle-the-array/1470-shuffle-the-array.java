class Solution {
    public int[] shuffle(int[] nums, int n) {
        var result = new int[2 * n];
        
        for(int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[n + i];
        }
        
        return result;
    }
}