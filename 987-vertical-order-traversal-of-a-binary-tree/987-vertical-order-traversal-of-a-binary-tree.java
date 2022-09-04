class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, PriorityQueue<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, root));
        
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node now = q.poll();
                
                min = Math.min(min, now.col);
                
                if(!map.containsKey(now.col)) map.put(now.col, new PriorityQueue<>());
                
                map.get(now.col).add(now);
                
                if(now.treeNode.left != null) q.add(new Node(now.row + 1, now.col - 1, now.treeNode.left));
                if(now.treeNode.right != null) q.add(new Node(now.row + 1, now.col + 1, now.treeNode.right));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = min; map.containsKey(i); i++) {
            PriorityQueue<Node> pq = map.get(i);
            List<Integer> temp = new ArrayList<>();
            
            while(!pq.isEmpty()) temp.add(pq.poll().treeNode.val);
            
            result.add(temp);
        }
        
        return result;
    }
    
    class Node implements Comparable<Node>{
        int row, col;
        TreeNode treeNode;
        
        public Node(int row, int col, TreeNode treeNode) {
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
        }
        
        @Override
        public int compareTo(Node n) {
            if(this.row == n.row) 
                return this.treeNode.val - n.treeNode.val;
            return this.row - n.row;
        }
    }
}