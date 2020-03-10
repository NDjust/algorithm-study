package practice.sort;

import java.util.Arrays;

public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int h = 0; h <= citations.length; h++) {
            for (int j = 0; j < citations.length; j++) {
                int citationsCount = citations[j];
                if (citationsCount >= h) {
                    int paperCount = citations.length - j;
                    if (h <= paperCount) {
                        if (answer <= h) {
                            answer = h;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] cit = {22, 42};
        System.out.println(solution(cit));
    }
}
