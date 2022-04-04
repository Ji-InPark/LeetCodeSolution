class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int length = 0;
        ListNode start = head, end = head;
        
        for(;start != null; start = start.next)
        {
            length++;
            map.put(length, start);
        }
        
        if(length == 1) return head;
        
        if(k > length / 2) k = length - k + 1;
        
        if(length == 2)
        {
            map.get(1).next = null;
            map.get(2).next = map.get(1);
            
            return map.get(2);
        }
        else if(k == 1)
        {
            map.get(1).next = null;
            map.get(length).next = map.get(2);
            map.get(length - 1).next = map.get(1);
            
            return map.get(length);
        }
        else if(2 * k == length)
        {
            map.get(k - 1).next = map.get(k + 1);
            map.get(k + 1).next = map.get(k);
            map.get(k).next = map.get(k + 2);
            
            return head;
        }
        else
        {
            map.get(k - 1).next = map.get(length - k + 1);
            map.get(length - k + 1).next = map.get(k + 1);
            map.get(length - k).next = map.get(k);
            map.get(k).next = map.get(length - k + 2);
            
            return head;
        }
    }
}