package goorm;

import java.util.Scanner;

public class AmusementPark {

    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        int answer = findMinimumTrash(wastes, K);

        System.out.println(answer);
    }

    private static int findMinimumTrash(int[][] wastes, final int k) {
        int ans = Integer.MAX_VALUE;
        int N = wastes.length;
        for (int i = 0; i <= N - k; i++) {
            for (int j = 0; j <= N - k; j++) {
                ans = Math.min(searchPark(wastes, i, j, k), ans);
            }
        }
        return ans;
    }

    private static int searchPark(final int[][] wastes, final int i, final int j, final int k) {
        int count = 0;
        for (int l = i; l < i + k; l++) {
            for (int m = j; m < j + k; m++) {
                if (wastes[l][m] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
