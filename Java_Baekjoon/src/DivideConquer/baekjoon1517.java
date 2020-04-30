package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1517 {

    private static long swapCount = 0;

    private static long[] a;

    private static long[] b;

    private static void sort(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(start, mid);
        sort(mid+1, end);
        merge(start, end);

    }
    private static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                swapCount += (mid - i+1);
            }
        }

        while (i <= mid) {
            b[k++] = a[i++];
        }

        while (j <= end) {
            b[k++] = a[j++];
        }

        for (int l = start; l <= end; l++) {
            a[l] = b[l- start];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = new long[n];
        b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        sort(0, n-1);

        System.out.println(swapCount);
    }
}
