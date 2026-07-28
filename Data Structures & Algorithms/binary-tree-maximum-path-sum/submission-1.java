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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }

    public int findMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);

        // Path starts at left, passes through root, and ends at right.
        int pathThroughNode = root.val + leftSum + rightSum;

        // Path containing only the current node.
        int onlyRoot = root.val;

        // Path containing root and only one child branch.
        int oneBranch = root.val + Math.max(leftSum, rightSum);

        int bestPathAtCurrentNode = Math.max(pathThroughNode, Math.max(oneBranch, onlyRoot));

        // Preserve the best result found anywhere in the tree.
        maxSum = Math.max(maxSum, bestPathAtCurrentNode);

        // Parent can use only one branch.
        return Math.max(onlyRoot, oneBranch);
    }
}
