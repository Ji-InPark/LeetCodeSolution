class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        long result = 1;
        for(int i = 2; i <= n; i++)
        {
            int space = (i - 1) * 2 + 1;
            result *= (space * (space + 1) / 2);
            result %= mod;
        }
        
        return (int)result;
    }
}