class Solution {
    public int removePalindromeSub(String s) {
        int left = 0, right = s.length() - 1;
        boolean flag = true;
        
        while(left <= right)
        {
            if(s.charAt(left++) != s.charAt(right--))
            {
                flag = false;
                break;
            }
        }
        
        return flag ? 1 : 2;
    }
}