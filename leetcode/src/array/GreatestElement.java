package array;


public class GreatestElement {

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        arr[n-1] = -1;

        if (n == 1) {
            return new int[]{-1};
        }

        for (int i = n-2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        GreatestElement g = new GreatestElement();

        int[] ints = g.replaceElements(new int[]{17,18,5,4,6,1});

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
