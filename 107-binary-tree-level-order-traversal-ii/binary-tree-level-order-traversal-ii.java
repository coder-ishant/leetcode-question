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
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<List<Integer>> st=new Stack<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> arr=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode newNode=q.poll();
                arr.add(newNode.val);
                if(newNode.left!=null) q.add(newNode.left);
                if(newNode.right!=null) q.add(newNode.right);
            }
            st.push(arr);
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }
}