package bfsdfs;

import java.util.*;

public class Leetcode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        treeNodes.add(root);
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);

        while (!treeNodes.isEmpty()) {
            int parentSize = treeNodes.size();
            List<Integer> childNodeVals = new ArrayList<>();

            for (int i = 0; i < parentSize; i++) {
                TreeNode poll = treeNodes.poll();

                if (poll.left != null) {
                    treeNodes.add(poll.left);
                }

                if (poll.right != null) {
                    treeNodes.add(poll.right);
                }
                childNodeVals.add(poll.val);
            }

            ans.add(childNodeVals);
        }

        Collections.reverse(ans);
        return ans;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
