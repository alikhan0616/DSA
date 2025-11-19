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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p == null && q == null) return true;
       if(p == null || q == null) return false;
       Queue<TreeNode> que1 = new LinkedList<>();
       Queue<TreeNode> que2 = new LinkedList<>();
       que1.offer(p);
       que2.offer(q);
       while(!que1.isEmpty() && !que2.isEmpty()){
        TreeNode curr1 = que1.poll();
        TreeNode curr2 = que2.poll();
        if(curr1.val != curr2.val) return false;
        if(curr1.left != null && curr2.left != null){
            que1.offer(curr1.left);
            que2.offer(curr2.left);
        } else if(curr1.left != null || curr2.left != null) return false;
        if(curr1.right != null && curr2.right != null){
            que1.offer(curr1.right);
            que2.offer(curr2.right);
        } else if(curr1.right != null || curr2.right != null) return false;
       
       }
       if(que1.isEmpty() && que2.isEmpty()) return true;
       return false;
    }
}