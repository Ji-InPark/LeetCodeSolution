class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node start = head;
        ArrayList<Node> arr = new ArrayList<Node>();
        for(int i = 0; head != null; i++)
        {
            arr.add(new Node(head.val));
            head.val = i;
            head = head.next;
        }
        
        head = start;
        arr.get(0).random = head.random == null ? null : arr.get(head.random.val);
        head = head.next;
        for(int i = 1; i < arr.size(); i++)
        {
            arr.get(i - 1).next = arr.get(i);
            arr.get(i).random = head.random == null ? null : arr.get(head.random.val);
            head = head.next;
        }
        
        return arr.get(0);
    }
}