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
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            // Number of nodes currently in the queue belongs to this level.
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.removeFirst(); // queue = [3], current = 2
                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.offerLast(current.left); // queue = [2]
                }

                if (current.right != null) {
                    queue.offerLast(current.right); // queue = [2, 3]
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
