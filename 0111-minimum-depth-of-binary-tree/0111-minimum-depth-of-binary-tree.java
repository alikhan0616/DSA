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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) return 0;
        int depth = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0 ; i < level ; i++){
                TreeNode curr = q.poll();
                if(curr.left == null && curr.right == null){
                    return depth;
                } 
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
}