class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        var oneZero = new int[2];
        int flipedOnes = 0;
        
        for(int i = 0; i < n; i++) oneZero[s.charAt(i) == '1' ? 1 : 0]++;

        int result = Math.min(oneZero[0], oneZero[1]);
        
        for(int i = 0; i < n; i++) {
            oneZero[s.charAt(i) == '1' ? 1 : 0]--;
            
            if(s.charAt(i) == '0') continue;
            
            result = Math.min(result, flipedOnes++ + Math.min(oneZero[0], oneZero[1] + 1));
        }
        
        return result;
    }
}