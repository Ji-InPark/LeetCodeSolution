class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();
        int index = 0, i = 0;
        
        while(i < pushed.length && s.push(pushed[i]) == pushed[i++])
            for(; !s.isEmpty() && s.peek() == popped[index]; index++) s.pop();
        
        return popped.length == index;
    }
}