package array;

public class SquaredSort {

    public int[] sortedSquares(int[] A) {
        int right = A.length-1;
        int left = 0;
        int idx = A.length-1;
        int[] ans = new int[A.length];

        while (left <= right) {
            if (Math.abs(A[right]) < Math.abs(A[left])) {
                ans[idx] = A[left] * A[left];
                left++;
            } else {
                ans[idx] = A[right] * A[right];
                right--;
            }

            idx--;
        }

        return ans;

    }
    public static void main(String[] args) {
        SquaredSort sort = new SquaredSort();

        sort.sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
