public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return null;
        
        var slow = head.next;
        var fast = head.next.next;
        
        while(true) {
            if(slow == fast || fast == null || fast.next == null) break;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null || fast.next == null) return null;
        
        slow = head;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}