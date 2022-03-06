class Solution {
    public int countOrders(int n) {
        long result = 1;
        int diff = 9, mul = 6;
        n--;
        while(n > 0)
        {
            result *= mul;
            mul += diff;
            diff += 4;
            result %= 1000000007;
            n--;
        }
        
        return (int)result;
    }
}