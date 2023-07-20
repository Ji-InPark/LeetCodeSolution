class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var s = new Stack<Integer>();
        
        for(var a: asteroids) {
            if(a > 0) {
                s.push(a);
                continue;
            }
            
            while(!s.isEmpty() && s.peek() > 0 && s.peek() + a < 0) s.pop();
            
            if(!s.isEmpty() && s.peek() + a == 0) s.pop();
            else if(s.isEmpty() || s.peek() < 0) s.push(a);
        }
        
        return stackToArray(s);
    }
    
    private int[] stackToArray(Stack<Integer> s) {
        var result = new int[s.size()];
        int index = s.size() - 1;
        while(!s.isEmpty()) result[index--] = s.pop();
        
        return result;
    }
}