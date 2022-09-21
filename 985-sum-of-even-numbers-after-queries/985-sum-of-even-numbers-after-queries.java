class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int even = 0;
        int[] result = new int[queries.length];
        for(int num: nums) even += num % 2 == 0 ? num : 0;
        for(int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            even -= nums[q[1]] % 2 == 0 ? nums[q[1]] : 0;
            nums[q[1]] += q[0];
            even += nums[q[1]] % 2 == 0 ? nums[q[1]] : 0;
            result[i] = even;
        }
        
        return result;
    }
}