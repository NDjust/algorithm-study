package DivideConquer;

import java.io.*;

public class baekjoon2263 {
    public static int[] inorder = new int[100000];
    public static int[] postorder = new int[100000];
    public static int[] position = new int[100001];

    public static void solve(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return;
        }
        int root = postorder[post_end];
        System.out.printf("%d ", root);
        int p = position[root];

        // inorder : in_start p in_end
        // postorder : post_start post_end
        int left = p - in_start;
        solve(in_start, p - 1, post_start, post_start + left -  1); // left
        solve(p + 1, in_end, post_start + left, post_end - 1); // right
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");
        String[] post = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.valueOf(in[i]);
            postorder[i] = Integer.valueOf(post[i]);
            position[inorder[i]] = i; // root position.
        }

        solve(0, n - 1, 0, n - 1);
    }
}
