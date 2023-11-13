class Solution {
    public String sortVowels(String s) {
        var set = new HashSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        var vowelArr = new ArrayList<Character>();
        var arr = s.toCharArray();
        
        for(var c : arr) 
            if(set.contains(c)) 
                vowelArr.add(c);
        
        Collections.sort(vowelArr);
        
        int index = 0;
        for(int i = 0; i < arr.length; i++) 
            if(set.contains(arr[i])) 
                arr[i] = vowelArr.get(index++);
        
        return new String(arr);
    }
}