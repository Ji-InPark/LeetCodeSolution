class Solution {
    String answerKey;
    int k;
    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        this.answerKey = answerKey;
        this.k = k;
        
        return Math.max(solve('T'), solve('F'));
    }
    
    public int solve(char tf) {
        int result = 0, reverseCount = 0, left = 0;
        
        for(int i = 0; i < answerKey.length(); i++) {
            if(answerKey.charAt(i) == tf) reverseCount++;
            
            while(reverseCount > k && left <= i) {
                reverseCount -= answerKey.charAt(left++) == tf ? 1 : 0;
            }
            
            result = Math.max(result, i - left + 1);
        }
        
        return result;
    }
}