class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        
        boolean[] check = new boolean[(int)Math.pow(2, k)];
        
        for(int i = 0; i <= s.length() - k; i++)
        {
            check[Integer.parseInt(s.substring(i, i + k), 2)] = true;
        }
        
        for(boolean flag : check) if(!flag) return false;
        
        return true;
    }
}