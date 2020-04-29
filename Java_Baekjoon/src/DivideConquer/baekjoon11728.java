package DivideConquer;

import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[n + m];
        {
            int i = 0;
            int j = 0;
            int k = 0;

            while (i < n || j < m) {
                if (i >= n || (j < m && arr1[i] > arr2[j])) {
                    ans[k++] = arr2[j++];
                } else {
                    ans[k++] = arr1[i++];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an + " ");
        }
        System.out.println(sb);
    }
}
