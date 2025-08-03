class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        
        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        inOrder(root.right, k);
    }
}
