class Solution {
public:
    string getSmallestString(int n, int k) {
        string result(n, 'a');
        
        k -= n;
        
        for(int i = n - 1; i >= 0; i--)
        {
            result[i] += (min(k, 25));
            k -= (k >= 25 ? 25 : k);
        }
        
        return result;
    }
};