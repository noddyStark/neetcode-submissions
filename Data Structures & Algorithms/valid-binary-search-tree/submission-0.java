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
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);

        for (int i=0; i < inOrderList.size(); i++) {

            if (i == 0) {
                continue;
            } else {
                if (inOrderList.get(i) <= inOrderList.get(i-1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> inOrderList) {

        if (root == null) {
            return;
        }

        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }
}
