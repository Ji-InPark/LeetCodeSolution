public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode fast = head, slow = head;
        
        while(true) {
            if(fast == null) return false;
            
            fast = fast.next;
            if(fast == null) return false;
            
            fast = fast.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
    }
}