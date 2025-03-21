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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list;
        
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int length=0;
        while(!q.isEmpty()){
            list=new ArrayList<>();
            length=q.size();
            for(int i=0;i<length;i++){
               TreeNode node=q.poll();
                list.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}