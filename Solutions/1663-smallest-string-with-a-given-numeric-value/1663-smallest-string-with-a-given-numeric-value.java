class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        k -= n;
        
        for(int i = n - 1; k > 0; i--)
        {
            arr[i] += Math.min(k, 25);
            k -= 25;
        }
        
        return new String(arr);
    }
}