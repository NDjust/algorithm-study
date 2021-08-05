package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FrogTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Integer> values = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int start = 1;
        int end = values.stream()
                .reduce(0, Integer::sum);

        while (start <= end) {
            int mid = (start + end) / 2;
            int health = getHealth(values, mid);

            if (health == 0) {
                System.out.println(mid);
                return;
            }

            if (health > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }

    private static boolean isPass(List<Integer> values, int mid) {
        return getHealth(values, mid) > 0;
    }

    private static int getHealth(List<Integer> values, int mid) {
        int health = mid;
        for (Integer value : values) {
            if (value % mid == 0) {
                health -= (value / mid);
            } else {
                health -= (value / mid) + 1;
            }
        }
        return health;
    }
}
