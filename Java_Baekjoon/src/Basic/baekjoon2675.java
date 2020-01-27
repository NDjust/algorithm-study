package Basic;

import java.util.Scanner;

public class baekjoon2675 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int rep = sc.nextInt();
            String word = sc.next();

            for (int j = 0; j < word.length(); j++) {
                char a = word.charAt(j);
                for (int k = 0; k < rep; k++) {
                    System.out.print(a);
                }
            }
            System.out.println();
        }
    }
}
