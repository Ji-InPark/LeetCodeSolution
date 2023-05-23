class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
        for(int i = 0; i < k - nums.length; i++) pq.add(-1000000);
        for(var num: nums) pq.add(num);
        while(pq.size() > k) pq.poll();
    }
    
    public int add(int val) {
        pq.add(val);
        pq.poll();
        return pq.peek();
    }
}