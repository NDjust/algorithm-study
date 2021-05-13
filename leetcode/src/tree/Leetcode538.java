package tree;

public class Leetcode538 {
    public static void main(String[] args) {
        final Leetcode538 leetcode538 = new Leetcode538();

    }

    public TreeNode convertBST(TreeNode root) {
        order(root, 0);
        return root;
    }

    private int order(final TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum = order(root.right, sum);
        root.val += sum;

        return order(root.left, root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
