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
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode nl, TreeNode nr) {
        if(nl == null && nr == null){
            return true;
        }
        if(nl == null || nr == null){
            return false;
        }
        return nl.val == nr.val && isMirror(nl.left, nr.right) && isMirror(nl.right, nr.left);
    }
}