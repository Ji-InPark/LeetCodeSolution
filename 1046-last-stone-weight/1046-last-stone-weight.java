class Solution {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(var s: stones) pq.add(s);
        
        while(pq.size() > 1) {
            var first = pq.poll();
            var second = pq.poll();
            
            if(first - second > 0) pq.add(first - second);
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}