class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode reverseHead = slow.next, pre = null;
        slow.next = null;
        
        while(reverseHead != null) {
            var temp = reverseHead.next;
            reverseHead.next = pre;
            pre = reverseHead;
            reverseHead = temp;
        }
        
        reverseHead = pre;
        
        int result = 0;
        while(head != null) {
            result = Math.max(result, head.val + reverseHead.val);
            head = head.next;
            reverseHead = reverseHead.next;
        }
        
        return result;
    }
}