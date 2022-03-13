class Solution {
    public boolean isValid(String input) {
        Stack<Character> s = new Stack<Character>();
        
        for(int i = 0; i < input.length(); i++)
        {
            char now = input.charAt(i);
            if(now == '(')
            {
                s.push(++now);
            }
            else if(now == '{' || now == '[')
            {
                ++now;
                s.push(++now);
            }
            else
            {
                if(s.isEmpty())
                    return false;
                if(s.peek() != now)
                    return false;
                s.pop();
            }
        }
        
        if(!s.isEmpty())
            return false;
        
        return true;
    }
}