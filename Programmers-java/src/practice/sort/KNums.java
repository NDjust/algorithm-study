package practice.sort;

import java.util.Arrays;

public class KNums {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int getPoint = commands[i][2];

            int[] subArray = new int[end - start + 1];
            int k = 0;

            for (int j = start - 1; j < end; j++) {
                subArray[k++] = array[j];
            }

            Arrays.sort(subArray);

            answer[i] = subArray[getPoint - 1];
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] ans = solution(arr, cmd);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }


    }
}
