class Solution {
    public boolean validPalindrome(String s) {
        int index = 0;
        boolean flag = false;
        for(index = 0; index <= (s.length() + 1) / 2; index++)
        {
            if(s.charAt(index) != s.charAt(s.length() - 1 - index))
            {
                flag = true;
                break;
            }
        }
        
        if(flag)
        {
            flag = false;
            
            for(int i = index; i < (s.length() + 1) / 2; i++)
            {
                if(s.charAt(i + 1) != s.charAt(s.length() - 1 - i))
                {
                    flag = true;
                    break;
                }
            }
            
            if(flag)
            {
                for(int i = index; i < (s.length() + 1) / 2; i++)
                {
                    //System.out.println(s.charAt(i) + " " + s.charAt(s.length() - 2 - i));
                    if(s.charAt(i) != s.charAt(s.length() - 2 - i)) return false;
                }
            }
        
        }
        
        return true;
        
    }
}