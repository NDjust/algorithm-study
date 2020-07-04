package chapter06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Picnic {

    private static boolean[][] isFriends = new boolean[10][10];

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine().trim());
        System.out.println(c);
        List<Integer> results = new ArrayList<>();

        while (c-- > 0) {
            n = br.read();
            m = br.read();

            List<Integer> studentNumbers = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int i = 0; i < studentNumbers.size(); i += 2) {
                isFriends[studentNumbers.get(i)][studentNumbers.get(i+1)] = true;
            }
            boolean[] taken = new boolean[10];
            results.add(countParings(taken));
        }

        for (Integer result : results) {
            System.out.println(result);
        }
    }

    private static int countParings(boolean[] taken) {
        int firstFree = -1;

        for (int i = 0; i < n; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        if (firstFree == -1) {
            return 1;
        }
        int ret = 0;

        for (int pairWidth = firstFree+1; pairWidth < n; pairWidth++) {
            if (!taken[pairWidth] && isFriends[firstFree][pairWidth]) {
                taken[pairWidth] = true;
                taken[firstFree] = true;
                ret += countParings(taken);
                taken[pairWidth] = false;
                taken[firstFree] = false;
            }
        }
        return ret;
    };
}
