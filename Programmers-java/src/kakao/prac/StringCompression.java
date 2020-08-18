package kakao.prac;

import java.util.Stack;

public class StringCompression {

    public int solution(String s) {
        int minLen = s.length();

        for (int i = 1; i <= s.length(); i++) {
            Stack<String> stack = new Stack<>();
            stack.add(s.substring(0, i));
            int duplicatedCount = 1;
            int len = 0;

            for (int j = i; j < s.length(); j += i) {
                int startIdx = j;
                int endIdx = Math.min(j + i, s.length());

                String nextStr = s.substring(startIdx, endIdx);
                String peek = stack.peek();
                if (nextStr.equals(peek)) {
                    duplicatedCount++;
                } else {
                    if (duplicatedCount != 1) {
                        // 자리 수 계산.
                        len += Math.log10(duplicatedCount) + 1;
                    }

                    len += stack.pop().length();
                    stack.add(nextStr);
                    duplicatedCount = 1;
                }
            }

            if (!stack.isEmpty()) {
                if (duplicatedCount != 1) {
                    len += Math.log10(duplicatedCount) + 1;
                }

                len += stack.pop().length();
            }


            minLen = Math.min(minLen, len);
        }

        return minLen;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        int aabbaccc = stringCompression.solution("aabbaccc");
        System.out.println(aabbaccc);
    }
}
