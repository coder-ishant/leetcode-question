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
    public static int sumPath(List<Integer> arr){
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        return sum;
    }
   public static void findPaths(TreeNode root, List<Integer> currentPath, List<List<Integer>> allPaths, int target) {
        if (root == null) return;

        currentPath.add(root.val);

        // If it's a leaf node, add a copy of the current path
        if (root.left == null && root.right == null) {
            if(sumPath(currentPath)==target){
                allPaths.add(new ArrayList<>(currentPath));
            }
        } else {
            findPaths(root.left, currentPath, allPaths, target);
            findPaths(root.right, currentPath, allPaths,target);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        findPaths(root,new ArrayList<>(),ans,targetSum);
        return ans;

    }
}