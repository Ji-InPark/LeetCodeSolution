class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode s = head, f = head, pre = null, e = null;
        
        while(true) {
            f = f.next;
            if(f == null) {
                e = s.next;
                s = pre;
                break;
            }
            f = f.next;
            if(f == null) {
                e = s.next;
                s.next = pre;
                break;
            }
            
            ListNode n = s.next;
            s.next = pre;
            pre = s;
            s = n;
        }
        
        while(s != null && e != null) {
            if(s.val != e.val) return false;
            s = s.next;
            e = e.next;
        }
        
        return s == null && e == null;
    }
}