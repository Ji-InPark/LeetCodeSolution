/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode result = new TreeNode(preorder[0]);
        map.put(preorder[0], result);
        int index = 1;
        boolean flag = true;
        
        for(int io : inorder){
            if(map.containsKey(io)){
                result = map.get(io);
                flag = false;
                continue;
            }
            
            while(index < preorder.length && preorder[index] != io){
                TreeNode temp = new TreeNode(preorder[index]);
                if(flag){
                    result.left = temp;
                    result = result.left;
                } else{
                    result.right = temp;
                    result = result.right;
                    flag = true;
                }
                map.put(preorder[index++], temp);
            }
            
            TreeNode temp = new TreeNode(preorder[index]);
            if(flag){
                result.left = temp;
                result = result.left;
            } else{
                result.right = temp;
                result = result.right;
            }
            map.put(preorder[index++], temp);
            flag = false;
        }
        
        return map.get(preorder[0]);
    }
}