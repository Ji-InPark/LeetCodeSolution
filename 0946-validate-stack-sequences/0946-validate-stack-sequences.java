class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        var s = new Stack<Integer>();
        int index = 0;
        
        for(var p : pushed) {
            s.push(p);
            while(!s.isEmpty() && s.peek() == popped[index]) {
                index++;
                s.pop();
            }
        }

        return s.isEmpty();
    }
}