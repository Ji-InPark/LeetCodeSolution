class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        
        if(s.length() == 1) return s;
        
        if(s.length() == 2) return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        
        for(int i = 0; i < s.length(); i++)
        {
            int left = i, right = i;
            
            while( 0 <= left && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            
            if(result.length() < right - left - 1)
            {
                result = s.substring(left + 1, right);
            }
            
            left = i; 
            right = i + 1;
            
            while( 0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) 
            {
                left--;
                right++;
            }
            
            if(right - left == 1) continue;
            
            if(result.length() < right - left - 1)
            {
                result = s.substring(left + 1, right);
            }
        }
        
        return result;
    }
}