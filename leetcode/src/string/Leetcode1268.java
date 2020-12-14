package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        int len = searchWord.length();

        for (int i = 1; i <= len; i++) {
            String substring = searchWord.substring(0, i);

            result.add(getCommonPrefixWords(substring, i, products));
        }

        return result;
    }

    private List<String> getCommonPrefixWords(final String substring, int endIdx, final String[] products) {
        List<String> words = new ArrayList<>();
        for (String product : products) {
            int idx = endIdx;

            if (product.length() < endIdx) {
                idx = product.length();
            }

            String productSubstring = product.substring(0, idx);

            if (productSubstring.equals(substring)) {
                words.add(product);
            }
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(final String s1, final String s2) {
                return s1.compareTo(s2);
            }
        });

        if (words.size() > 3) {
            return words.subList(0, 3);
        }

        return words;
    }

    public static void main(String[] args) {
        Leetcode1268 leetcode1268 = new Leetcode1268();
        String[] products = {
                "code","codephone","coddle","coddles","codes"
        };

        String searchWord = "coddle";
        List<List<String>> lists = leetcode1268.suggestedProducts(products, searchWord);

        System.out.println(lists.toString());
    }
}
