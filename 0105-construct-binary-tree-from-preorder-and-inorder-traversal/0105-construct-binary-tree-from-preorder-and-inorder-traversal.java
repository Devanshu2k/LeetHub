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
        if (preorder.length == 0) return null;

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            int currVal = preorder[i];
            TreeNode node = new TreeNode(currVal);
            TreeNode parent = stack.peek();

            if (inorderIndexMap.get(currVal) < inorderIndexMap.get(parent.val)) {
                // Left child case
                parent.left = node;
                stack.push(node);
            } else {
                // Find the parent to which this is the right child
                while (!stack.isEmpty() &&
                    inorderIndexMap.get(currVal) > inorderIndexMap.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
                stack.push(node);
            }
        }

        return root;
    }
}