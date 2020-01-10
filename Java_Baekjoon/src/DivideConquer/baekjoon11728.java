package DivideConquer;

import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekjoon11728 {

    public static void main(String[] args) throws IOException {
        // 입력 메모리 초과로 Scanner -> BufferReader 로 대체해서 입력을 받야함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);

        int[] a = new int[n];
        int[] b = new int[m];

        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(line[i]);
        }


        line = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.valueOf(line[i]);
        }

        int[] c = new int[n + m];

        {
            int i = 0;
            int j = 0;
            int k = 0;

            while (i < n || j < m) {
                if (j >= m || (i < n && a[i] <= b[j])) {
                    c[k++] = a[i++];
                } else {
                    c[k++] = b[j++];
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n + m; i++) {
            sb.append(c[i] + " ");
        }
        System.out.println(sb);
    }
}
