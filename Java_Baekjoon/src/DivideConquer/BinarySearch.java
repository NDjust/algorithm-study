package DivideConquer;

import java.util.Scanner;

public class BinarySearch {
    public static int Search(int[] a, int t) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == t) {
                return mid;
            } else if (a[mid] > t) {
                right = mid - 1;
            } else if (a[mid] < t) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        if (Search(a, t) == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println(Search(a, t));
        }
    }
}
