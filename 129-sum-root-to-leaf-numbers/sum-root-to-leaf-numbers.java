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
    public static int convertNum(List<Integer> curr){
        int n=curr.size()-1;
        int sum=0;
        int i=0;
        while(n>=0 && i<curr.size()){
            sum+=Math.pow(10,n)*curr.get(i);
            n--;
            i++;
        }
        return sum;
    }
    public static void findPaths(TreeNode root, List<Integer> current,int[] ans){
        if(root==null){return;}
        current.add(root.val);
        if(root.left==null && root.right==null){
            ans[0]+=convertNum(current);
        }
        else{
            findPaths(root.left,current,ans);
            findPaths(root.right,current,ans);
        }
        current.remove(current.size()-1);
    }
    public int sumNumbers(TreeNode root) {
        int[] ans=new int[1];
        findPaths(root,new ArrayList<>(), ans);
        return ans[0];
    }
}