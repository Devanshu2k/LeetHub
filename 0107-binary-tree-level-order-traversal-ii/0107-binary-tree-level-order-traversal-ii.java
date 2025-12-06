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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ansList = new ArrayList<>();

        q.offer(root);
        while(q.size()!=0){
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp!=null){              
                    q.add(temp.left);
                    q.add(temp.right);
                    levelList.add(temp.val);
            }
            }
            if(!levelList.isEmpty())
                ansList.add(levelList);
        }
        Collections.reverse(ansList);
        return ansList;
    }
}