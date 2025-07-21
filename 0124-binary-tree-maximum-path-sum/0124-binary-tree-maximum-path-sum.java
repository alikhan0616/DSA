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
    public int maxPathSum(TreeNode root) {
        int[] sumArr = new int[1];
        sumArr[0] = Integer.MIN_VALUE;
        maxPath(root, sumArr);
        return sumArr[0];
    }

    private int maxPath(TreeNode node, int[] sumArray){
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(0, maxPath(node.left, sumArray));
        int rightSum = Math.max(0, maxPath(node.right, sumArray));
        sumArray[0] = Math.max(sumArray[0], node.val + leftSum + rightSum);
        return Math.max(leftSum, rightSum) + node.val;
    }
}