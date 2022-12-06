class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, en = head.next;

        while(true) {
            if(en.next == null) break;
            head.next = en.next;
            head = head.next;

            if(head.next == null) break;
            en.next = head.next;
            en = en.next;
        }

        head.next = even;
        en.next = null;

        return odd;
    }
}