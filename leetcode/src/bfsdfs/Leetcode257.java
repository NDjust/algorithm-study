package bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {

    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(root, list);

        return ans;
    }

    private void dfs(final TreeNode root, List<Integer> values) {

        if (root.left == null && root.right == null) {
            addAns(values);
            return;
        }

        if (root.left != null) {
            values.add(root.left.val);
            dfs(root.left, values);
            values.remove(values.size()-1);
        }

        if (root.right != null) {
            values.add(root.right.val);
            dfs(root.right, values);
            values.remove(values.size()-1);
        }
    }

    private void addAns(final List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (Integer value : values) {
            sb.append(value);
            sb.append("->");
        }

        ans.add(sb.substring(0, sb.length()-2));
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node5;

        Leetcode257 leetcode257 = new Leetcode257();
        List<String> list = leetcode257.binaryTreePaths(root);

    }
}
