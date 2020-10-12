package bfsdfs;

import java.util.*;

public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            LinkedList<Integer> values = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                // LEFT OR RIGHT
                if (level % 2 == 0) {
                    values.addFirst(node.val);
                } else {
                    values.addLast(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;

            result.add(values);
        }
        return result;
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

    private static enum Direct {
        LEFT,
        RIGHT
    }
}
