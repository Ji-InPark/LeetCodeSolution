class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        var arr = new boolean[n];
        var oneZero = new int[2];
        int flipedOnes = 0;
        
        for(int i = 0; i < n; i++){
            arr[i] = s.charAt(i) == '1';
            oneZero[arr[i] ? 1 : 0]++;
        }
        
        int result = Math.min(oneZero[0], oneZero[1]);
        
        for(int i = 0; i < n; i++) {
            oneZero[arr[i] ? 1 : 0]--;
            
            if(!arr[i]) continue;
            
            result = Math.min(result, flipedOnes++ + Math.min(oneZero[0], oneZero[1] + 1));
        }
        
        return result;
    }
}