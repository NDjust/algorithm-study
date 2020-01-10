package DivideConquer;

public class MergeSort {
    static int[] a = {2, 5, 1, 2, 10, 22, 44};
    static int[] b = new int[a.length];

    public static void main(String[] args) {
        System.out.println("Previous Sort");

        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        sort(0, a.length - 1);

        System.out.println("\nSort");

        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }

    }

    public static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) {
            b[k++] = a[i++];
        }

        while (j <= end) {
            b[k++] = a[j++];
        }

        for (i = start; i <= end; i++) {
            a[i] = b[i - start];
        }
    }

    public static void sort(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }
}
