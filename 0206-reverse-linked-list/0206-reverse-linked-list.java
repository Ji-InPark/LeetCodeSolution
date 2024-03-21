class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode node = null, run = head;

        while(run != null) {
            var temp = run.next;
            run.next = node;
            node = run;
            run = temp;
        }

        return node;
    }
}