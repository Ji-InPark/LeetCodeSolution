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