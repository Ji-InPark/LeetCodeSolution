class Solution {
    public int threeSumMulti(int[] nums, int target) {
        long[] count = new long[105];
        int mod = 1000000007;
        long result = 0;
 
        for(int num : nums) count[num]++;

        for(int i = 0; i <= 100; i++)
        {
            for(int j = i; j <= 100; j++)
            {
                int k = target - i - j;
                if(k > 100 || k < 0) continue;

                if(i == j && j == k)
                {
                    result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                }
                else if(i == j && j != k)
                {
                    result += count[i] * (count[i] - 1) / 2 * count[k];
                }
                else if(j < k)
                {
                    result += count[i] * count[j] * count[k];
                }
            }
        }
        
        return (int)(result % mod);
    }
}