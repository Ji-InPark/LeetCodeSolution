class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        
        boolean unique = true;
        int pre = head.val;
        ListNode temp = head;
        ListNode node = new ListNode();
        ListNode result = node;
        
        head = head.next;
        
        while(head != null)
        {
            if(head.val == pre)
            {
                unique = false;
            }
            else
            {
                if(unique)
                {
                    node.next = temp;
                    node = node.next;
                    node.next = null;
                }
                
                pre = head.val;
                temp = head;
                unique = true;
            }
            
            head = head.next;
        }
        if(unique)
            node.next = temp;
        
        return result.next;
    }
}