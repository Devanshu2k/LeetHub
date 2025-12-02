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
    class Pair{
        TreeNode node;
        int num;

        Pair(TreeNode node,int num){
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int max = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                Pair pair = q.poll();
                TreeNode tempNode = pair.node;
                int tempNum = pair.num;
                if(i==0) first = tempNum;
                if(i==size-1) last = tempNum;

                if(tempNode.left!=null) q.offer(new Pair(tempNode.left,tempNum*2+1));
                if(tempNode.right!=null) q.offer(new Pair(tempNode.right,tempNum*2+2));
            }
            max = Math.max(max,last-first+1);
        }

        return max;
    }
}