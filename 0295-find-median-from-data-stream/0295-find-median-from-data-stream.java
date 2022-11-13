class MedianFinder {
    PriorityQueue<Integer> spq = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> bpq = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        var small = spq.peek();
        var big = bpq.peek();
        
        if(small == null && big == null) {
            spq.add(num);
        } else {
            if(small >= num) {
                bpq.add(spq.poll());
                spq.add(num);
            } else {
                bpq.add(num);
            }
        }
        
        while(Math.abs(spq.size() - bpq.size()) > 1) {
            if (spq.size() > bpq.size()) bpq.add(spq.poll());
            else spq.add(bpq.poll());
        }
    }
    
    public double findMedian() {
        var small = spq.peek();
        var big = bpq.peek();
        
        if(spq.size() != bpq.size()) {
            if(spq.size() > bpq.size()) return small;
            else return big;
        }
        
        if(small == null) small = 0;
        if(big == null) big = 0;
        
        return (double)(small + big) / 2;
    }
}