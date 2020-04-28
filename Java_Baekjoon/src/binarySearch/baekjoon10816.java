package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon10816 {

    private static int findLowerBound(List<Integer> card, int target) {
        int start = 0;
        int end = card.size();

        while (end > start) {
            int mid = (start + end) / 2;

            if (card.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int findUpperBound(List<Integer> card, int target) {
        int start = 0;
        int end = card.size();

        while (end > start) {
            int mid = (start + end) / 2;

            if (card.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getCount(List<Integer> card, int target) {
        return findUpperBound(card, target) - findLowerBound(card, target);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> card = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            sb.append(getCount(card, value)).append(" ");
        }
        System.out.println(sb);
    }
}
