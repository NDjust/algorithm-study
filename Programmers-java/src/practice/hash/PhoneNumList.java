package practice.hash;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumList {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        loop:
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int k = i+1; k < phone_book.length; k++) {
                if (phone_book[i].equals(phone_book[k].substring(0, phone_book[i].length()))) {
                    answer = false;
                    break loop;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        String[] phone = {"12", "123", "1235", "567", "88"};
        System.out.println(solution(phone));
    }
}
