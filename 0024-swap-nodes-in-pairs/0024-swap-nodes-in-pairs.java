class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        var result = new ListNode();
        var pre = result;
        while(head != null && head.next != null) {
            var temp = head.next;
            head.next = temp.next;
            temp.next = head;
            
            pre.next = temp;
            pre = head;
            
            head = head.next;
        }
        
        return result.next;
    }
}