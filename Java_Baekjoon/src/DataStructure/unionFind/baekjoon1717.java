package DataStructure.unionFind;

import java.util.Scanner;

public class baekjoon1717 {

    private static int[] parent = new int[1000001];

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        while (m != 0) {
            int w = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (w == 0) {
                union(x, y);
            } else {
                x = find(x);
                y = find(y);

                if (x == y) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            m--;
        }
    }
}
