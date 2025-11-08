class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);          // Visit root
        preorder(node.left, res);   // Visit left
        preorder(node.right, res);  // Visit right
    }
}
