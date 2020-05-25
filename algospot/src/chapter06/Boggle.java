package chapter06;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Boggle {

    private static char[][] gameBoard = new char[5][5];

    private static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] dy = {-1, 1, 1, 0, -1, 0, 1, -1};
    private static boolean[][] visited = new boolean[5][5];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 5; i++) {
            char[] chars = br.readLine().toCharArray();
            System.arraycopy(chars, 0, gameBoard[i], 0, 5);
        }

        HashMap<String, String> results = new LinkedHashMap<>();
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                boolean result = false;
                String word = br.readLine();

                loop:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (hasWord(i, j, word)) {
                            result = true;
                            break loop;
                        };

                    }
                }

                if (result) {
                    results.put(word, "YES");
                } else {
                    results.put(word, "NO");
                }
            }
        }

        for (String s : results.keySet()) {
            bw.write(s + " " +results.get(s));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static boolean hasWord(int x, int y, String word) {
        if (isRange(x, y)) {
            return false;
        }

        if (word.charAt(0) != gameBoard[x][y]) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int mx = dx[i] + x;
            int my = dy[i] + y;
            if (hasWord(mx, my, word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= 5 || y >= 5;
    }
}
