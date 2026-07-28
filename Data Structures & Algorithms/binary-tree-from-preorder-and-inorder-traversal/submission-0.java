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
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store each value's position in inorder.
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
            /*
            2 -> 0
            1 -> 1
            3 -> 2
            4 -> 3
            */
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inorderLeft, int inorderRight) {
        // No elements remain in this inorder range.
        if (inorderLeft > inorderRight) {
            return null;
        }

        // Preorder always gives us the next root.
        int rootValue = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootValue);

        // Locate the root in inorder.
        int rootInorderIndex = inorderIndexMap.get(rootValue); // 1

        // Build everything to the left of the root.
        root.left = build(preorder, inorderLeft, rootInorderIndex - 1);

        // Build everything to the right of the root.
        root.right = build(preorder, rootInorderIndex + 1, inorderRight);

        return root;
    }
}
