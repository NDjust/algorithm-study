package string;

import java.util.*;

public class Leetcode1233 {

    Node root = new Node();  // Trie Root
    List<String> ans = new ArrayList<>();

    public List<String> removeSubfolders(String[] folder) {
        for (String f : folder) {
            insert(f);
        }

        for (Node child : root.children.values()) {
            findFirstNonNull(child);
        }

        return ans;
    }

    private void findFirstNonNull(final Node node) {
        if (node.word != null) {
            ans.add(node.word);
            return;
        }

        for (Node child : node.children.values()) {
            findFirstNonNull(child);
        }
    }

    private void insert(final String folder) {
        Node curr = root;
        StringTokenizer st = new StringTokenizer(folder, "/");

        while (st.hasMoreTokens()) {
            if (curr.word != null) {
                return;
            }

            String str = st.nextToken();

            if (!curr.children.containsKey(str)) {
                curr.children.put(str, new Node());
            }

            curr = curr.children.get(str);
        }

        curr.word = folder;
    }


    private static class Node {
        Map<String, Node> children = new HashMap<>();
        String word;
    }

    public static void main(String[] args) {
        Leetcode1233 leetcode1233 = new Leetcode1233();
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
        List<String> strings = leetcode1233.removeSubfolders(folder);
        System.out.println(strings.toString());
    }
}
