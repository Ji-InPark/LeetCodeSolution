class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        
        var clone = new Node(node.val);
        map.put(node.val, clone);
        for(var neighbor: node.neighbors) {
            var clonedNeigbor = cloneGraph(neighbor);
            clone.neighbors.add(clonedNeigbor);
        }
        
        return clone;
    }
}