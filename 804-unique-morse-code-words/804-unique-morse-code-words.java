class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        int result = 0;
        
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            
            for(char c : word.toCharArray()) sb.append(arr[c - 'a']);
            
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                result++;
            }
        }
        
        return result;
    }
}