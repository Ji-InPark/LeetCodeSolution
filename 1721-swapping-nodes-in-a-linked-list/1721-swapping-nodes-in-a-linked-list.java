class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode result = head, first = head, second = head;
        for(int i = 1; head != null; i++) {
            if(i == k) first = head;
            if(i > k) second = second.next;
            head = head.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return result;
    }
}