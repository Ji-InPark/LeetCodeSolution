class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(var num: nums) pq.add(num);
        while(pq.size() > k) pq.poll();
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k) pq.poll();
        return pq.peek();
    }
}