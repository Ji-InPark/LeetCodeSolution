class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head);
            head = head.next;
        }
        
        arr.remove(arr.size() - n);
        
        for(int i = 0; i < arr.size() - 1; i++) {
            arr.get(i).next = arr.get(i + 1);
        }
        if(!arr.isEmpty()) arr.get(arr.size() - 1).next = null;
        
        return arr.isEmpty() ? null : arr.get(0);
    }
}