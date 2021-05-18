package tree;

public class Leetcode129 {

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        sumTree(root, 0);
        return ans;
    }

    private void sumTree(final TreeNode root, final int currentSum) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            ans += root.val + (currentSum * 10);
            return;
        }

        sumTree(root.right, currentSum * 10 + root.val);
        sumTree(root.left, currentSum * 10 + root.val);
    }
}
