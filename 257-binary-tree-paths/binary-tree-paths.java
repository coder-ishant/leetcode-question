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
    public static String convertString(List<Integer> curr){
        String str="";
        for(int i=0;i<curr.size();i++){
            str+=(curr.get(i)).toString()+"->";
        }
        return str.substring(0,str.length()-2);
    }
    public static void findPaths(TreeNode root,List<Integer> curr,List<String> ans){
        if(root==null){
            return;
        }
       curr.add(root.val);

        if(root.left==null && root.right==null){
            String temp=convertString(curr);
            ans.add(temp);
        }
        else{
            findPaths(root.left,curr,ans);
            findPaths(root.right,curr,ans);
        }
        curr.remove(curr.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        findPaths(root,new ArrayList<>(),ans);
        return ans;
    }
}