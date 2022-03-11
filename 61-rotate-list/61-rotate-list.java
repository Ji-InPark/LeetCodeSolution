class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode node = head;
        int index;
        for(index = 1; node.next != null; index++) node = node.next;
        node.next = head;
        for(int i = 0; i < index - (k % index); i++)
            node = node.next;
        head = node.next;
        node.next = null;
        return head;
    }
}