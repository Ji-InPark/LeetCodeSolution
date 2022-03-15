class Solution {
    public String minRemoveToMakeValid(String input) {
        boolean[] valid = new boolean[input.length()];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < input.length(); i++)
        {
            char now = input.charAt(i);
            if(now == '(')
            {
                s.push(i);
            }
            else if(now == ')')
            {
                if(!s.isEmpty())
                    valid[i] = valid[s.pop()] = true;
            }
            else
            {
                valid[i] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++)
        {
            if(valid[i])
                sb.append(input.charAt(i));
        }
        
        return sb.toString();
    }
}