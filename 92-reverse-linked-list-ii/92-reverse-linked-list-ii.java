class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        
        Stack<ListNode> s = new Stack<>();
        
        ListNode now = head;
        if(left != 1) {
            int index = 1;
            for(; index < left - 1; index++) now = now.next;
            ListNode start = now;
            for(; index < right; index++) {
                now = now.next;
                s.push(now);
            }
            
            ListNode end = now.next != null ? now.next : null;
            
            while(!s.isEmpty()) {
                start.next = s.pop();
                start = start.next;
            }
            
            start.next = end;
            
            return head;
        } else {
            for(int i = 1; i <= right; i++) {
                s.push(now);
                now = now.next;
            }
            
            ListNode result = s.pop();
            ListNode start = result;
            while(!s.isEmpty()) {
                start.next = s.pop();
                start = start.next;
            }
            
            start.next = now != null ? now : null;
            
            return result;
        }
    }
}