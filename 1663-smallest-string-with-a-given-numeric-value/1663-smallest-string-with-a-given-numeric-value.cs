public class Solution {
    public string GetSmallestString(int n, int k) {
        char[] arr = new char[n];
        k -= n;
        
        for(int i = n - 1; i >= 0; i--)
        {
            arr[i] += (char)('a' + (k < 25 ? k : 25));
            k -= (k >= 25 ? 25 : k);
        }
        
        return new string(arr);
    }
}