class MyCircularQueue {
    Queue<Integer> q = new LinkedList<>();
    int rear;
    int size;
    
    public MyCircularQueue(int k) {
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        
        q.add(value);
        rear = value;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        
        q.poll();
        
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : q.peek();
    }
    
    public int Rear() {
        return isEmpty() ? -1 : rear;
    }
    
    public boolean isEmpty() {
        return q.isEmpty();
    }
    
    public boolean isFull() {
        return q.size() == size;
    }
}