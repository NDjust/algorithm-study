package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2805 {
    private static long[] trees;

    private static long n;

    private static long m;
    private static boolean check(long cutLength) {
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            if (trees[i] - cutLength > 0) {
                cnt = cnt + (trees[i] - cutLength);
            }
        }

        return cnt >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long maxLengthTree = 0;
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        trees = new long[(int) n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            maxLengthTree = Math.max(maxLengthTree, trees[i]);
        }

        long left = 1;
        long right = maxLengthTree;
        long ans = 0;
        while (right >= left) {
            long mid = (right + left) / 2;

            if (check(mid)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
