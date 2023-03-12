class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        var pq = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
        for(var node: lists) {
            while(node != null) {
                pq.add(node);
                node = node.next;
            }
        }
        
        if(pq.isEmpty()) return null;
        
        var result = pq.poll();
        var head = result;
        
        while(!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }
        
        head.next = null;
        
        return result;
    }
}