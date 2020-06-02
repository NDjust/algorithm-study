package practice.binarySearch;

import java.util.Arrays;

public class SteppingStone {

    public int solution(int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        Arrays.sort(rocks);

        while (end >= start) {
            int mid = (start + end) / 2;
            int prevStone = 0;
            int cnt = 0;

            for (int rock : rocks) {
                if (rock - prevStone < mid) {
                    // 바위 제거.
                    cnt++;
                } else {
                    prevStone = rock;
                }
            }

            if (distance - prevStone < mid) cnt++;

            if (cnt > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {

    }
}
