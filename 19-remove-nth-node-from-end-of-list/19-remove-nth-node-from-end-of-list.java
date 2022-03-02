/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode first = head;
        int size = 0;
        
        for(int i = 0; head != null; i++)
        {
            size++;
            map.put(i, head);
            head = head.next;
        }
        
        if(size == 1)
            return null;
        
        if(size - n == 0)
            return first.next;

        head = map.get(size - n - 1);
        
        head.next = head.next.next;
        
        return first;
    }
}