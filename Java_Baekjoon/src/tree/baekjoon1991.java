package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class baekjoon1991 {
    private static HashMap<String, ArrayList<String>> binaryTree = new HashMap<>();

    private static void preOrder(String v) {
        if (v.equals(".")) {
            return;
        }
        System.out.printf("%s", v);
        preOrder(binaryTree.get(v).get(0));
        preOrder(binaryTree.get(v).get(1));
    }

    private static void inorder(String v) {
        if (v.equals(".")) {
            return;
        }
        inorder(binaryTree.get(v).get(0));
        System.out.printf("%s", v);
        inorder(binaryTree.get(v).get(1));
    }

    private static void postorder(String v) {
        if (v.equals(".")) {
            return;
        }

        postorder(binaryTree.get(v).get(0));
        postorder(binaryTree.get(v).get(1));
        System.out.printf("%s", v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] nodes = sc.nextLine().split(" ");
            ArrayList<String> leftRight = new ArrayList<>();
            leftRight.add(nodes[1]);
            leftRight.add(nodes[2]);
            binaryTree.put(nodes[0], leftRight);
        }
        preOrder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }
}



