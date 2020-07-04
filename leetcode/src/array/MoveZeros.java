package array;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeros(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();

        moveZeros.moveZeros(new int[] {0,1,0,3,12});
    }
}
