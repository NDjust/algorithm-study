package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1415 {

    private StringBuilder selectedChar = new StringBuilder();
    private List<String> happyStrings = new ArrayList<>();
    private char[] happyLetters = new char[]{'a', 'b', 'c'};

    public Leetcode1415() {
    }

    public String getHappyString(int n, int k) {
        searchKthString(n);

        if (happyStrings.size() < k) {
            return "";
        }
        return happyStrings.get(k-1);
    }

    private void searchKthString(final int n) {
        if (selectedChar.length() == n) {
            happyStrings.add(selectedChar.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            char happyLetter = happyLetters[i];

            if (selectedChar.length() != 0 && selectedChar.charAt(selectedChar.length()-1) == happyLetter) {
                continue;
            }

            selectedChar.append(happyLetter);
            searchKthString(n);
            selectedChar.delete(selectedChar.length()-1, selectedChar.length());


        }
    }


    public static void main(String[] args) {
        Leetcode1415 leetcode1415 = new Leetcode1415();
        System.out.println(leetcode1415.getHappyString(3, 9));
    }
}
