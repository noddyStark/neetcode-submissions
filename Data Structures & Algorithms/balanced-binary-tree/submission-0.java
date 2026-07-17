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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        calCulateHeight(root);
        return isBalanced;
    }

    private int calCulateHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = calCulateHeight(root.left); // 1 for Node 1
        int rightHeight = calCulateHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
