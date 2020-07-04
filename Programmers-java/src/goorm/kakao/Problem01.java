package goorm.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int level = 0;

        if (input.length() >= 10) {
            level += 1;
        }
        String removeLower = input.replaceAll("[a-z]", "");
        if (removeLower.length() != input.length()) {
            level += 1;
        }
        String removeUpper = removeLower.replaceAll("[A-Z]", "");
        if (removeUpper.length() != removeLower.length()) {
            level += 1;
        }

        String removeNum = removeUpper.replaceAll("[0-9]", "");

        if (removeUpper.length() != removeNum.length()) {
            level += 1;
        }

        if (removeNum.length() > 0) {
            level += 1;
        }

        System.out.println("LEVEL" + level);
    }

}
