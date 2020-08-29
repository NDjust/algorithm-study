package kakao.prac;

import java.util.ArrayList;
import java.util.List;

public class Compression {
    public int[] solution(String msg) {
        List<String> words = new ArrayList<>();

        words.add("");

        for (int i = 0; i < 26; i++) {
            words.add(String.valueOf((char) (i + 65)));
        }

        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < msg.length(); i++) {

            int size = 1;

            String currWord = msg.substring(i, i + size);

            if (i + size >= msg.length()) {
                size -= 1;
            }

            String nextWord = msg.substring(i, i + size + 1);


            boolean isLast = false;

            while (words.contains(nextWord)) {
                currWord = nextWord;
                size++;

                if (size + i >= msg.length()) {
                    size = size - 1;
                    isLast = true;
                    break;
                }

                nextWord = msg.substring(i, i + size + 1);
            }



            int index = findIndex(currWord, words);
            idx.add(index);

            if (!words.contains(nextWord)) {
                words.add(nextWord);
            }

            System.out.println(words.toString());

            if (isLast) {
                break;
            }
            i = i + size - 1;
        }

        int[] answer = new int[idx.size()];

        for (int i = 0; i < idx.size(); i++) {
            answer[i] = idx.get(i);
        }

        System.out.println(idx.toString());
        return answer;
    }

    public int findIndex(String word, List<String> words) {

        for (int i = 0; i < words.size(); i++) {
            if (word.equals(words.get(i))) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Compression compression = new Compression();
        String msg = "KAKAO";
        compression.solution(msg);
    }
}
