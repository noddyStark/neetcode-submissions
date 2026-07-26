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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root); // Queue = [1]

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 2
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                // Queue = [], current = 1
                // Queue = [3], current = 2
                // Queue = [], current = 3
                TreeNode current = queue.removeFirst();

                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.offerLast(current.left);
                    // Queue = [2], current = 1
                }

                if (current.right != null) {
                    queue.offerLast(current.right);
                    // Queue = [2, 3], current = 1
                }
            }

        }

        return result;
    }
}
