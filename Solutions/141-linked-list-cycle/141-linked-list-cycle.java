public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head.next, fast = head.next.next;
        
        while(slow != null && fast != null)
        {
            if(slow == fast)
                return true;
            try
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            catch(Exception e)
            {
                break;
            }
        }
        
        return false;
    }
}