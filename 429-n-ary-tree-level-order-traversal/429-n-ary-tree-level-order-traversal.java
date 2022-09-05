class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                Node now = q.poll();
                
                temp.add(now.val);
                
                List<Node> list = now.children;
                
                for(int j = 0; j < list.size(); j++) {
                    q.add(list.get(j));
                }
            }
            
            result.add(temp);
        }
        
        return result;
    }
}