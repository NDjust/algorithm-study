package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwitchString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length / 2; i++) {
            sb.append(input.charAt(i));
            sb.append(input.charAt(length - i - 1));
        }
        if (length % 2 == 1) {
            sb.append(input.charAt(length / 2));
        }
        System.out.println(sb.toString());
    }
}

