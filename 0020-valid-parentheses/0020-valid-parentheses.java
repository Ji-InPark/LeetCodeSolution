class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        
        for(var c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') { 
                stack.push(c);
                continue;
            }
            
            if(stack.isEmpty()) return false;
            
            switch(c) {
                case ')':
                    if(stack.pop() != '(') return false;
                    break;
                case '}':
                    if(stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.pop() != '[') return false;
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}