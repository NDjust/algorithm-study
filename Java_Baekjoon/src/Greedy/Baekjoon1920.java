package Greedy;

import java.io.*;
import java.util.Arrays;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputN =  br.readLine().split(" ");
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputN[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            int result = binarySearch(A, Integer.parseInt(targets[i]));

            System.out.println(result);
        }


        br.close();
        bw.close();
    }

    public static int binarySearch(int[] array, int target) {
        int front = 0;
        int end = array.length - 1;
        int mid;

        while (front <= end) {
            mid = (front + end) / 2;

            if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                front = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
