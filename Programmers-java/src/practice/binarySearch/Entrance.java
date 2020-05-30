package practice.binarySearch;

import java.util.Arrays;

public class Entrance {

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = (long)times[times.length - 1] * (long)n;
        long left = 0;
        long right = (long)times[times.length - 1] * (long)n;

        while (right >= left) {
            long mid = (right + left) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(6 , new int[]{7,10}));
    }
}
