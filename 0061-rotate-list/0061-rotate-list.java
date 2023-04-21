class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        int length = 1;
        var node = head;
        
        for(; node.next != null; length++) 
            node = node.next;
        
        node.next = head;
        
        for(int i = 0; i < length - (k % length); i++) 
            node = node.next;
        
        var result = node.next;
        node.next = null;
        
        return result;
    }
}