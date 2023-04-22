class Solution {
    public ListNode partition(ListNode head, int x) {
        var before_start = new ListNode();
        var before = before_start;
        var after_start = new ListNode();
        var after = after_start;
        
        while(head != null) {
            if(head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;
        before.next = after_start.next;
        
        return before_start.next;
    } 
}