class Solution {
    public String reverseVowels(String s) {
        var set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        var stack = new Stack<Character>();
        var arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                stack.push(arr[i]);
                arr[i] = '*';
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '*') {
                arr[i] = stack.pop();
            }
        }
        
        return new String(arr);
    }
}