class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for(int i = 0; i < t.length(); i++)
        {
            try
            {
                if(s.charAt(index) == t.charAt(i))
                {
                    index++;
                }
            }
            catch(Exception e)
            {
                break;
            }
        }
        
        return index == s.length();
    }
}