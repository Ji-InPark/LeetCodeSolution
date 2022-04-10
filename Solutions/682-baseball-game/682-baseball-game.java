class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        
        for(String op : ops)
        {
            if(op.equals("C"))
            {
                s.pop();
            }
            else if(op.equals("D"))
            {
                s.push(s.peek() * 2);
            }
            else if(op.equals("+"))
            {
                int temp = s.pop();
                int last = s.peek() + temp;
                
                s.push(temp);
                s.push(last);
            }
            else
            {
                s.push(Integer.parseInt(op));
            }
        }
        
        int result = 0;
        while(!s.isEmpty()) result += s.pop();
        
        return result;
    }
}