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
    static class Result {
        int height;
        boolean isPerfect;
        int size;

        Result(int height, boolean isPerfect, int size) {
            this.height = height;
            this.isPerfect = isPerfect;
            this.size = size;
        }
    }

    List<Integer> sizes = new ArrayList<>();

    public Result dfs(TreeNode node) {
        if (node == null) return new Result(0, true, 0);

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        boolean isPerfect = left.isPerfect && right.isPerfect && left.height == right.height;
        int height = Math.max(left.height, right.height) + 1;
        int size = left.size + right.size + 1;

        if (isPerfect) sizes.add(size);

        return new Result(height, isPerfect, size);
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        sizes.clear();
        dfs(root);
        Collections.sort(sizes, Collections.reverseOrder());
        return (sizes.size() >= k) ? sizes.get(k - 1) : -1;
    }
    
}