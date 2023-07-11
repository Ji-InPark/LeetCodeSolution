class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var map = buildMapGraph(root);
        var set = new HashSet<Integer>();
        var q = new LinkedList<Integer>();
        
        q.add(target.val);
        while(!q.isEmpty()) {
            if(k-- == 0) return q;
            
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var now = q.poll();
                set.add(now);
                for(var child: map.get(now)) if(!set.contains(child)) q.add(child);
            }
        }
        
        return new ArrayList<>();
    }
    
    private HashMap<Integer, List<Integer>> buildMapGraph(TreeNode root) {
        var map = new HashMap<Integer, List<Integer>>();
        
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            var now = q.poll();
            if(!map.containsKey(now.val)) map.put(now.val, new ArrayList<>());
            
            if(now.left != null) {
                if(!map.containsKey(now.left.val)) map.put(now.left.val, new ArrayList<>());
                map.get(now.val).add(now.left.val);
                map.get(now.left.val).add(now.val);
                q.add(now.left);
            }
            
            if(now.right != null) {
                if(!map.containsKey(now.right.val)) map.put(now.right.val, new ArrayList<>());
                map.get(now.val).add(now.right.val);
                map.get(now.right.val).add(now.val);
                q.add(now.right);
            }
        }
        
        return map;
    }
}