class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode result = new ListNode(), nodeHead = result, node = result;
        
        while(head != null) {
            node.next = head;
            node = node.next;
            head = head.next;
            
            if(length++ >= n) nodeHead = nodeHead.next;
        }
        
        nodeHead.next = nodeHead.next.next;
        
        return result.next;
        
    }
}