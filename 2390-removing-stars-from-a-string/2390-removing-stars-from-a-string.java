class Solution {
    public String removeStars(String s) {
        var d = new ArrayDeque<Character>();
        for(var c : s.toCharArray()) {
            if(c == '*') d.pollLast();
            else d.addLast(c);
        }
        
        var sb = new StringBuilder();
        while(!d.isEmpty()) sb.append(d.pollFirst());
        
        return sb.toString();
    }
}