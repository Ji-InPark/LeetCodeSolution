class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            int pre = 0;
            boolean isFirst = true;
            
            for(int i = 0; i < size; i++) {
                TreeNode now = q.poll();
                
                // 레벨이 짝수일때
                if(level % 2 == 0) {
                    if(now.val % 2 == 0) return false;
                    
                    if(!isFirst && pre >= now.val) return false;
                    
                    isFirst = false;
                    pre = now.val;
                    
                } 
                // 레벨이 홀수일 때
                else {
                    if(now.val % 2 == 1) return false;
                    
                    if(!isFirst && pre <= now.val) return false;
                    
                    isFirst = false;
                    pre = now.val;
                }
                
                if(now.left != null) q.add(now.left);
                if(now.right != null) q.add(now.right); 
                
            }
            
            level++;
        }
        
        return true;
    }
}