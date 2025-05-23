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
    public static void leaf(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            arr.add(root.val);
        }
        else{
            leaf(root.left,arr);
            leaf(root.right,arr);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        leaf(root1,arr1);
        leaf(root2,arr2);
        return arr1.equals(arr2);
    }
}