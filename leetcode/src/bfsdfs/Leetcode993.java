package bfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        treeNodes.add(root);

        if (root == null) {
            return false;
        }

        while (!treeNodes.isEmpty()) {
            int len = treeNodes.size();

            for (int i = 0; i < len; i++) {
                TreeNode poll = treeNodes.poll();

                set.add(poll.val);

                if (poll.left != null && poll.right != null && poll.left.val == x && poll.right.val == y) {
                    return false;
                }

                if (poll.left != null && poll.right != null && poll.left.val == y && poll.right.val == x) {
                    return false;
                }

                if (set.contains(x) && set.contains(y)) {
                    return true;
                }

                if (poll.left != null) {
                    treeNodes.add(poll.left);
                }

                if (poll.right != null) {
                    treeNodes.add(poll.right);
                }
            }

            set = new HashSet<>();
        }

        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(final int val) {
            this.val = val;
        }

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
