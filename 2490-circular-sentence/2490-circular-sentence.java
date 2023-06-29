class Solution {
    public boolean isCircularSentence(String sentence) {
        var arr = sentence.split(" ");
        
        for(int i = 1; i < arr.length; i++) {
            if(last(arr[i - 1]) != first(arr[i])) return false;
        }
        
        return first(arr[0]) == last(arr[arr.length - 1]);
    }
    
    private char first(String s) {
        return s.charAt(0);
    }
    
    private char last(String s) {
        return s.charAt(s.length() - 1);
    }
}