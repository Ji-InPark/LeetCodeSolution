class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head);
            head = head.next;
        }
        
        arr.remove(arr.size() - n);
        
        if(arr.isEmpty()) return null;
        
        if(arr.size() > 1) {
            if(n == 1) arr.get(arr.size() - n).next = null;
            else if(n == arr.size() + 1) return arr.get(0);
            else arr.get(arr.size() - n).next = arr.get(arr.size() - n + 1);
        } else {
            arr.get(0).next = null;
        }
        
        return arr.get(0);
    }
}