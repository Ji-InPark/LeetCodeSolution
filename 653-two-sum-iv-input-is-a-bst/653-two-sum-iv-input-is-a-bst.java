class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode now = q.poll();
                
                if(now == null) continue;
                
                if(set.contains(k - now.val)) return true;
                
                set.add(now.val);
                
                q.add(now.left);
                q.add(now.right);
            }
        }
        
        return false;
    }
}