class Solution {
    public int scoreOfParentheses(String input) {    
        Stack<Integer> s = new Stack<Integer>();
        int[] level = new int[26];
        int result = 0, lv = 0;
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '(')
                lv++;
            else
            {
                if(level[lv] == 0)
                    level[lv - 1] += 1;
                else
                {
                    level[lv - 1] += level[lv] * 2;
                    level[lv] = 0;
                }
                
                lv--;
            }
        }
        
        return level[0];
    }
}