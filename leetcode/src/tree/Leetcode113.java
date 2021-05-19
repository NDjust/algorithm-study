package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode113 {

    private List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        searchSum(root, new ArrayList<>(), targetSum, 0);
        return ans;
    }

    private void searchSum(final TreeNode root, final ArrayList<IndexTree> currPath, int targetSum, int idx) {
        if (root == null) {
            return;
        }

        currPath.add(new IndexTree(idx, root));

        if (root.right == null && root.left == null) {
            List<Integer> path = currPath.stream()
                    .map(node -> node.node.val)
                    .collect(Collectors.toList());
            int sum = path.stream()
                    .reduce(0, Integer::sum);

            if (sum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }

        searchSum(root.right, currPath, targetSum, idx * 2 + 1);
        searchSum(root.left, currPath, targetSum, idx * 2 + 2);
        removePreviousNode(currPath, idx);
    }

    private void removePreviousNode(final ArrayList<IndexTree> currPath, final int idx) {
        currPath.removeIf(indexTree -> indexTree.idx == idx);
    }

    private static class IndexTree {
        int idx;
        TreeNode node;

        public IndexTree(final int idx, final TreeNode node) {
            this.idx = idx;
            this.node = node;
        }

        @Override
        public String toString() {
            return "IndexTree{" +
                    "idx=" + idx +
                    ", node=" + node.val +
                    '}';
        }
    }
}
