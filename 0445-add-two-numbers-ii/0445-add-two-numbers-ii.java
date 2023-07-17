import java.math.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var n1 = new BigInteger("0");
        var n2 = new BigInteger("0");
        
        while(l1 != null) {
            n1 = n1.multiply(BigInteger.TEN).add(BigInteger.valueOf(l1.val));
            l1 = l1.next;
        }
        
        while(l2 != null) {
            n2 = n2.multiply(BigInteger.TEN).add(BigInteger.valueOf(l2.val));
            l2 = l2.next;
        }
        
        var num = n1.add(n2).toString();
        var result = new ListNode(0);
        var runner = result;
        
        for(int i = 0; i < num.length(); i++) {
            runner.next = new ListNode(num.charAt(i) - '0');
            runner = runner.next;
        }
        
        return result.next;
    }
}