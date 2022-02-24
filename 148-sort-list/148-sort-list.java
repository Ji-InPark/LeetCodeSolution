class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        if(head == null)
            return head;
        
        while(head != null)
        {
            arr.add(head.val);
            head = head.next;
        }
        
        Collections.sort(arr);
        
        ListNode root = new ListNode();
        ListNode result = root;
        
        for(int i = 0; i < arr.size(); i++)
        {
            ListNode temp = new ListNode();
            root.next = temp;
            root = temp;
            root.val = arr.get(i);
        }
        
        return result.next;
    }
}