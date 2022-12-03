class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, StringBuilder>();
        
        for(var c : s.toCharArray()) {
            if(!map.containsKey(c)) map.put(c, new StringBuilder());
            map.get(c).append(c);
        }
        
        var pq = new PriorityQueue<String>((a, b) -> b.length() - a.length());
        
        for(var v: map.values()) pq.add(v.toString());
        
        var result = new StringBuilder();
        
        while(!pq.isEmpty()) result.append(pq.poll());
        
        return result.toString();
    }
}