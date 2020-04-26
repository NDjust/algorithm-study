package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2110 {

    static int n;
    static int c;
    static List<Integer> list;

    private static boolean isOk(int mid) {
        int cnt = 1;
        int last = list.get(0);

        for (Integer value : list) {
            if (value- last >= mid) {
                cnt++;
                last = value;
            }
        }
        return cnt >= c;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        // sorting
        Collections.sort(list);

        int left = 1;
        int right = list.get(list.size()-1) - list.get(0);
        int ans = 0;

        while (right >= left) {
            int mid = (right+left) / 2;
            if (isOk(mid)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
