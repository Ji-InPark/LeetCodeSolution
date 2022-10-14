class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        ListNode s = head, f = head, pre = null;
        
        while(true) {
            f = f.next;
            if(f == null) {
                pre.next = s.next;
                break;
            }
            
            f = f.next;
            if(f == null) {
                s.next = s.next.next;
                break;
            }
            
            pre = s;
            s = s.next;
        }
        
        return head;
    }
}