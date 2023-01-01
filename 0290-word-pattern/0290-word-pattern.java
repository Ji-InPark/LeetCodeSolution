class Solution {
    public boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        var set = new HashSet<String>();
        var patterns = pattern.toCharArray();
        var arr = s.split(" ");
        
        if(patterns.length != arr.length) return false;
        
        for(int i = 0; i < patterns.length; i++) {
            var c = patterns[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(arr[i])) return false;
            } else {
                if(set.contains(arr[i])) return false;
                map.put(c, arr[i]);
                set.add(arr[i]);
            }
        }
        
        return true;
    }
}