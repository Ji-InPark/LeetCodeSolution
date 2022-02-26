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
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger first = new BigInteger("0"), second = new BigInteger("0"), result = new BigInteger("0");
        BigInteger f_index = new BigInteger("1"), s_index = new BigInteger("1");
        
        while(l1.next != null)
        {
            first = first.add(f_index.multiply(BigInteger.valueOf(l1.val)));
            f_index = f_index.multiply(BigInteger.valueOf(10));
            l1 = l1.next;
        }
        first = first.add(f_index.multiply(BigInteger.valueOf(l1.val)));
        
        while(l2.next != null)
        {
            second = second.add(s_index.multiply(BigInteger.valueOf(l2.val)));
            s_index = s_index.multiply(BigInteger.valueOf(10));
            l2 = l2.next;
        }
        second = second.add(s_index.multiply(BigInteger.valueOf(l2.val)));
        
        result = result.add(first);
        result = result.add(second);
        
        ListNode rNode = new ListNode();
        ListNode tail = rNode;
        
        while(true)
        {
            ListNode temp = new ListNode();
            
            tail.val = result.remainder(BigInteger.valueOf(10)).intValue();
            result = result.divide(BigInteger.valueOf(10));
            
            if(result.toString().equals("0"))
                break;
            
            tail.next = temp;
            tail = temp;
        }
        
        return rNode;

    }
}