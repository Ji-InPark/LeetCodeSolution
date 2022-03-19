class Solution {
    public String longestPalindrome(String s) {
        ArrayList<Integer>[] arr = new ArrayList[100];
        
        for(int i = 0; i < s.length(); i++)
        {
            int index = s.charAt(i) - '0';
            
            if(arr[index] == null)
                arr[index] = new ArrayList<Integer>();
            
            arr[index].add(i);
        }
        
        String result = "";
        int result_length = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int index = s.charAt(i) - '0';
            for(int j = arr[index].size() - 1; j >= 0; j--)
            {
                int length = arr[index].get(j) - i + 1;
                if(length > result_length)
                {
                    if(check(s, i, length + i - 1))
                    {
                        result_length = length;
                        result = s.substring(i, i + length);
                        break;
                    }
                }
                else
                    break;
            }
        }
        
        return result;
    }
    
    public boolean check(String s, int start, int end)
    {
        while(start <= end)   
        {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}