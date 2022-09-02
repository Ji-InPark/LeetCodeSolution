class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode now = q.poll();
                sum += now.val;
                
                if(now.left != null) q.add(now.left);
                if(now.right != null) q.add(now.right);
            }
            
            result.add(sum / size);
        }
        
        return result;
    }
}