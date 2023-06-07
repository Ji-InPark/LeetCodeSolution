class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        
        while(a > 0 || b > 0 || c > 0) {
            int ar = a % 2, br = b % 2, cr = c % 2;
            a >>= 1; b >>= 1; c >>= 1;
            if(cr == (ar | br)) continue;
            
            if(cr == 1) result++;
            else result += ar + br;
        }
        
        return result;
    }
}
