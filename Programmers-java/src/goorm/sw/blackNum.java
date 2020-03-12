package goorm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class blackNum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] arr = br.readLine().split(" ");

        int ans = 0;

        for (int i = 0; i < n - 1; i += (k - 1)) {
            ans++;
        }

        System.out.println(ans);

    }
}
