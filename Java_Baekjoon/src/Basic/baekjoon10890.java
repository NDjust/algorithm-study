package Basic;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon10890 {

    public static int findIndex(String word, char alpha) {

        for (int i = 0; i < word.length(); i++) {
            if (alpha == word.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char c = 'a';

        for (int j = 0; j < 26; j++) {

            char alpha = (char)(c + j);
            System.out.printf("%d ", findIndex(word, alpha));
        }

    }
}
