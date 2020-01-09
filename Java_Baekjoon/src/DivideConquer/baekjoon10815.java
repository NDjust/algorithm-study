package DivideConquer;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon10815 {

    public static boolean BinarySearch(int[] cards, int target) {
        int left = 0;
        int right = cards.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] == target) {
                return true;
            } else if (cards[mid] > target) {
                right = mid - 1;
            } else if (cards[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] cardNums = new int[n];

        for (int i = 0; i < n; i++) {
            cardNums[i] = sc.nextInt();
        }

        Arrays.sort(cardNums);
        sc.nextLine();

        int m = Integer.parseInt(sc.nextLine());
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            if (BinarySearch(cardNums, a)) {
                ans.append("1 ");
            } else {
                ans.append("0 ");
            }
        }

        System.out.println(ans);
    }
}
