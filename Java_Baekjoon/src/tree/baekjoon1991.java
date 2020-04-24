package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon1991 {

    private static HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

    private static void preorder(String node) {
        if (node.equals(".")) {
            return;
        }
        System.out.printf("%s", node);
        preorder(hashMap.get(node).get(0));
        preorder(hashMap.get(node).get(1));
    }

    private static void inorder(String node) {
        if (node.equals(".")) {
            return;
        }
        inorder(hashMap.get(node).get(0));
        System.out.printf("%s", node);
        inorder(hashMap.get(node).get(1));
    }

    private static void postorder(String node) {
        if (node.equals(".")) {
            return;
        }
        postorder(hashMap.get(node).get(0));
        postorder(hashMap.get(node).get(1));
        System.out.printf("%s", node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sc.nextLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            ArrayList<String> leftRight = new ArrayList<>();
            leftRight.add(left); leftRight.add(right);
            hashMap.put(node, leftRight);
        }
        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");

    }
}
