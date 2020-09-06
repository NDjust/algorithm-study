package kakao.prac;

import java.util.Arrays;

public class SearchingLyric {

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            int sameWordCount = 0;

            for (String word : words) {
                System.out.println(word);
//                if (word.length() != query.length()) {
//                    break;
//                } else {
//                    System.out.println(query);

                    if (query.charAt(0) == '?') {
                        int frontLastWildIdx = getFrontLastWildIdx(query);
                        String querySub = query.substring(frontLastWildIdx);
                        String wordSub = word.substring(frontLastWildIdx);

                        if (querySub.equals(wordSub)) {
                            sameWordCount++;
                        }

                    } else if (query.charAt(query.length() - 1) == '?') {
                        int lastWildIdx = getLastWildIdx(query);
                        String querySub = query.substring(0, lastWildIdx);
                        String wordSub = word.substring(0, lastWildIdx);

                        if (querySub.equals(wordSub)) {
                            sameWordCount++;
                        }
                    }

            }
            answer[i] = sameWordCount;

        }
        return answer;
    }

    public int getFrontLastWildIdx(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != '?') {
                return i;
            }
        }

        return 0;
    }


    public int getLastWildIdx(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c != '?') {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SearchingLyric lyric = new SearchingLyric();
        String[] words = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] solution = lyric.solution(words, queries);

        System.out.println(Arrays.toString(solution));
    }
}
