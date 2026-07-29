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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        StringBuilder result = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offerLast(root);
        result.append(root.val);

        while (!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();

            // Serialize the left child.
            if (current.left != null) {
                result.append(",").append(current.left.val);
                queue.offerLast(current.left);
            } else {
                result.append(",#");
            }

            // Serialize the right child.
            if (current.right != null) {
                result.append(",").append(current.right.val);
                queue.offerLast(current.right);
            } else {
                result.append(",#");
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("#")) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offerLast(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.removeFirst();

            // Reconstruct the left child.
            if (!values[index].equals("#")) {
                current.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offerLast(current.left);
            }

            index++;

            // Reconstruct the right child.
            if (index < values.length && !values[index].equals("#")) {
                current.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offerLast(current.right);
            }

            index++;
        }
        return root;
    }
}
