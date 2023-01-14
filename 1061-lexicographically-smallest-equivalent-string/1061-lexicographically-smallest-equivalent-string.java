class Solution {
    int[] arr = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i = 0; i < arr.length; i++) arr[i] = i;
        
        for(int i = 0; i < s1.length(); i++) {
            int c1 = find(s1.charAt(i) - 'a'), c2 = find(s2.charAt(i) - 'a');
            
            if(c1 == c2) continue;
            
            arr[Math.max(c1, c2)] = Math.min(c1, c2);
        }
        
        var sb = new StringBuilder();
        for(var c : baseStr.toCharArray()) sb.append((char)('a' + find(c - 'a')));
        
        return sb.toString();
    }
    
    public int find(int num) {
        if(arr[num] == num) return num;
        else return  arr[num] = find(arr[num]);
    }
}