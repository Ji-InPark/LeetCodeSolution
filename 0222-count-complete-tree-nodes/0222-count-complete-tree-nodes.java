class Solution {
    public int countNodes(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var node = q.poll();
                
                if(node == null) continue;
                
                result++;
                
                q.add(node.left);
                q.add(node.right);
            }
        }
        
        return result;
    }
}