class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        var pq = new PriorityQueue<Integer>();
        int result = 0;
        
        for(int i = 0; i < rocks.length; i++) pq.add(capacity[i] - rocks[i]);
        
        while(!pq.isEmpty()) {
            additionalRocks -= pq.poll();
            
            if(additionalRocks < 0) break;
            result++;
        }
        
        return result;
    }
}