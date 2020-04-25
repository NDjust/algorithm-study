package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon1654 {

    static long[] lineLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long maxLength = 0;
        lineLength = new long[k];

        for (int i = 0; i < k; i++) {
            lineLength[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(maxLength, lineLength[i]);
        }

        long left = 1;
        long right = maxLength;
        long ans = 0;

        while (left <= right) {
            long mid = (left+right) / 2;

            if (check(mid, k, n)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(long mid, int k, int n) {
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            cnt += lineLength[i] / mid;
        }

        return cnt >= n;
    }
}
