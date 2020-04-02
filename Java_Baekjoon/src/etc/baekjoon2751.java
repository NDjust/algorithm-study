package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon2751 {
    public static int[] b;
    public static int[] a;

    public static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (b[i] < b[j]) {
                a[k++] = b[i++];
            } else {
                a[k++] = b[j++];
            }
        }

        while (i <= mid) {
            a[k++] = b[i++];
        }

        while (j <= end) {
            a[k++] = b[j++];
        }


        for (i = start; i <= end; i++) {
            b[i] = a[i - start];
        }
    }

    public static void sort(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> data = new ArrayList<Integer>();
            for(int i = 0; i<n; i++) {
                data.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(data);
            for(int i = 0; i<n; i++) {
                System.out.println(data.get(i));
            }
        } catch (Exception e) {
            // TODO: handle exception e.printStackTrace();
        }
    }
}
