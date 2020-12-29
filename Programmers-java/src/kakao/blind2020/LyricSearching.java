package kakao.blind2020;

import java.util.HashMap;
import java.util.Map;

public class LyricSearching {

    public int[] solution(String[] words, String[] queries) {
        // 단어 길이별 트리
        Trie[] tries = new Trie[100001];

        // 모든 단어 트리 구성
        for (String word : words) {
            // 같은 길이 기준으로 트리를 구성
            int n = word.length();

            if (tries[n] == null) {
                tries[n] = new Trie();
            }

            tries[n].insert(word);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i].length();

            // 검색할 쿼리문 길이로 트리가 없을시 0
            if (tries[n] == null) {
                answer[i] = 0;
            } else {
                // 트리 검색
                answer[i] = tries[n].getCount(queries[i]);
            }
        }

        return answer;
    }

    private static class TreeNode {
        private Map<Character, TreeNode> children;
        private int count; // 현제 노드 기준 자식 노드의 수 (공통 접두사 개수)

        TreeNode() {
            this.children = new HashMap<>();
            this.count = 0;
        }

        public Map<Character, TreeNode> getChildren() {
            return children;
        }

        public int getCount() {
            return count;
        }

        public void increaseCount() {
            count++;
        }
    }

    private static class Trie {
        TreeNode front;
        TreeNode back;

        public Trie() {
            this.front = new TreeNode();
            this.back = new TreeNode();
        }

        public void insert(String word) {
            insertFront(word);
            insertBack(word);
        }

        private void insertFront(final String word) {
            TreeNode node = front;

            for (int i = 0; i < word.length(); i++) {
                node.increaseCount();
                // 해당 char이 자식노드에 없을 시 자식 노드에 추가
                node = node.getChildren().computeIfAbsent(word.charAt(i), key-> new TreeNode());
            }
        }

        private void insertBack(final String word) {
            TreeNode node = this.back;

            for (int i = word.length() - 1; i >= 0; i--) {
                node.increaseCount();
                node = node.getChildren().computeIfAbsent(word.charAt(i), c -> new TreeNode());
            }
        }

        public int getCount(String query) {
            if (query.charAt(0) == '?') {
                return getCountFromBack(query);
            }

            return getCountFromFront(query);
        }

        /**
         *
         * @param query : 검색할 쿼리
         * @return 해당 쿼리 공통된 접두사 혹은 전미사로 구성된 단어의 개수
         */
        private int getCountFromFront(final String query) {
            TreeNode node = this.front;

            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                if (c == '?') {
                    break;
                }

                // 매칭이 안되는 경우
                if (!node.getChildren().containsKey(c)) {
                    return 0;
                }

                node = node.getChildren().get(c);
            }
            return node.count;
        }

        /**
         *
         * @param query : 검색할 쿼리
         * @return 해당 쿼리 공통된 접두사 혹은 전미사로 구성된 단어의 개수
         */
        private int getCountFromBack(final String query) {
            TreeNode node = this.back;

            for (int i = query.length() - 1; i >= 0; i--) {
                char c = query.charAt(i);
                if (c == '?') {
                    break;
                }

                if (!node.getChildren().containsKey(c)) {
                    return 0;
                }

                node = node.getChildren().get(c);
            }

            return node.count;
        }
    }
}
