class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n == 1) return true;
        
        long num = 2;
        
        while(String.valueOf(n).length() > String.valueOf(num).length()) num *= 2;
        
        
        Loop:
        while(String.valueOf(n).length() == String.valueOf(num).length()) {
            int[] arr = new int[10];
            for(char c : String.valueOf(num).toCharArray()) arr[c - '0']++;
            for(char c : String.valueOf(n).toCharArray()) arr[c - '0']--;
            num *= 2;
            for(int number: arr) if(number != 0) continue Loop;
            
            return true;
        }
        
        return false;
    }
}