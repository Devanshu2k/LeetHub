class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    int helper(TreeNode root, int max) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= max) count++;

        max = Math.max(max, root.val);
        count += helper(root.left, max);
        count += helper(root.right, max);

        return count;
    }
}
