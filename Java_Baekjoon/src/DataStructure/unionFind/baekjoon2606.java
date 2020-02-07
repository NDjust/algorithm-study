package DataStructure.unionFind;

import java.util.Scanner;

public class baekjoon2606 {

    private static int[] parent = new int[101];

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
            parent[y]= x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        while (m != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
            m--;
        }

        int ans = 0;

        for (int i = 2; i <= n; i++) {
            if (find(1)  == find(i)) {
                ans++;
            }

        }
        System.out.println(ans);
    }
}
