class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return root == null ? 0 : ((low <= root.val && root.val <= high) ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}