import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> s1 = new LinkedList<Integer>();
        Queue<Integer> s2 = new LinkedList<Integer>();
        
        for(int i = 0; l1 != null; i++) 
        {
            s1.add(l1.val);
            l1 = l1.next;
        }
        
        for(int i = 0; l2 != null; i++)
        {
            s2.add(l2.val);
            l2 = l2.next;
        }
        
        ListNode result = new ListNode();
        ListNode node = result;
        int next = 0;
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            int now = next + (s1.isEmpty() ? 0 : s1.poll()) + (s2.isEmpty() ? 0 : s2.poll());
            node.next = new ListNode(now % 10);
            next = now / 10;
            node = node.next;
        }
        
        if(next > 0)
        {
            node.next = new ListNode(next);
            node = node.next;
        }
        
        return result.next;
    }
}