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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }

    public TreeNode helper(int[] nums,int left,int right){
        if(left>right)
            return null;

        int maxIdx = left;
        for(int i=left+1;i<=right;i++){
            if(nums[maxIdx]<nums[i])
                maxIdx = i;
        }

        TreeNode newNode = new TreeNode(nums[maxIdx]);
        newNode.left = helper(nums,left,maxIdx-1);
        newNode.right = helper(nums,maxIdx+1,right);

        return newNode;
    }
}