package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class baekjoon2866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        char[][] table = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                table[i][j] = row.charAt(j);
            }
        }

        Set<String> stringSet = new LinkedHashSet<>();

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                sb.append(table[j][i]);
            }
            stringSet.add(sb.toString());
        }

        int ans = 0;

        for (int i = 1; i < r; i++) {
            Set<String> subSet = new LinkedHashSet<>();

            for (String s : stringSet) {
                String substring = s.substring(i, s.length());
                subSet.add(substring);
            }

            if (subSet.size() < c) {
                break;
            } else {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
