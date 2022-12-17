class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for(var t : tokens) {
            if(t.equals("+")) {
                int n = s.pop();
                s.push(s.pop() + n);
            } else if(t.equals("-")) {
                int n = s.pop();
                s.push(s.pop() - n);
            } else if(t.equals("*")) {
                int n = s.pop();
                s.push(s.pop() * n);
            } else if(t.equals("/")) {
                int n = s.pop();
                s.push(s.pop() / n);
            } else {
                s.push(Integer.parseInt(t));
            }
        }
        
        return s.pop();
    }
}