class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0, right = tokens.length - 1, score = 0;
        Arrays.sort(tokens);
        
        if(tokens.length == 1) {
            return tokens[0] <= power ? 1 : 0;
        }
        
        while(left <= right) {
            while(left <= right && power >= tokens[left]) {
                power -= tokens[left++];
                score++;
            }
            
            if(left <= right) {
                if(score == 0) return 0;
                
                if(left == right) break;
                
                power += tokens[right--];
                score--;
            }
        }
        
        return score;
    }
}