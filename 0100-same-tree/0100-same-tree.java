class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var pq = new LinkedList<TreeNode>();
        var qq = new LinkedList<TreeNode>();
        
        pq.add(p);
        qq.add(q);
        
        while(true) {
            if(pq.size() != qq.size()) return false;
            int size = pq.size();
            if(size == 0) break;
            
            for(int i = 0; i < size; i++) {
                var pnow = pq.poll();
                var qnow = qq.poll();
                
                if(pnow == null && qnow == null) continue;
                if(pnow == null ^ qnow == null || pnow.val != qnow.val) return false; 
                
                pq.add(pnow.left);
                pq.add(pnow.right);
                qq.add(qnow.left);
                qq.add(qnow.right);
            }
        }
        
        return true;
    }
}