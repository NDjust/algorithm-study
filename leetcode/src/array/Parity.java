package array;

import java.util.Arrays;

public class Parity {

    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0 && idx != i) {
                int temp = A[i];
                A[i] = A[idx];
                A[idx] = temp;
                idx++;
            } else if (A[i] % 2 == 0 && idx == i) {
                idx++;
            }
        }

        System.out.println(Arrays.toString(A));
        return A;
    }
    public static void main(String[] args) {
        Parity p = new Parity();

        p.sortArrayByParity(new int[]{3,1,2,4});
    }
}
