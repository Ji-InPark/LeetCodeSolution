class FreqStack {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<node> pq = new PriorityQueue<>();
    int index = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.offer(new node(val, map.get(val), index++));
    }
    
    public int pop() {
        node n = pq.poll();
        map.put(n.val, map.get(n.val) - 1);
        return n.val;
    }
}

class node implements Comparable<node>
{
    int val, fre, index;
    
    public node(int val, int fre, int index)
    {
        this.val = val;
        this.fre = fre;
        this.index = index;
    }
    
    @Override   
    public int compareTo(node n) {
        if(n.fre == this.fre)
        {
            return n.index - this.index;
        }
        return n.fre - this.fre;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */