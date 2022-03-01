class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            int temp = i;
            while(temp > 0)
            {
                if(temp % 2 == 1) result[i]++;
                temp /= 2;
            }
        }
        return result;
    }
}