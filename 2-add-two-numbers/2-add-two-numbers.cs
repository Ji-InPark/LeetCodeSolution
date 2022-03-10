/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        int next = 0;
        
        while(l1 != null || l2 != null)
        {
            int now = next + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            node.next = new ListNode(now % 10);
            next = now / 10;
            node = node.next;
            
            l1 = l1?.next;
            l2 = l2?.next;
        }
        
        if(next > 0)
        {
            node.next = new ListNode(next);
            node = node.next;
        }
        
        return result.next;
    }
}