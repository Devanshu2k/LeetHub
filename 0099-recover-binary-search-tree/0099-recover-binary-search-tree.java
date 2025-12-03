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
    TreeNode first;
    TreeNode last;
    TreeNode prev;

    void inorder(TreeNode root){
        if(root==null)
            return;
        
        inorder(root.left);
        if(prev==null)
            prev = root;
        if(root.val<prev.val){
            if(first==null)
                first = prev;
            last = root;
        }

        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
    }
}