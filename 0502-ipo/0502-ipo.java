class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        var map = new TreeMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < profits.length; i++) {
            if(!map.containsKey(capital[i])) map.put(capital[i], new ArrayList<>());
            map.get(capital[i]).add(profits[i]);
        }
        
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int result = w;
        
        for(int i = 0; i < k; i++) {
            while(map.floorKey(result) != null) {
                pq.addAll(map.get(map.floorKey(result)));
                map.remove(map.floorKey(result));
            }
            
            if(!pq.isEmpty()) result += pq.poll();
        }
        
        return result;
    }
}