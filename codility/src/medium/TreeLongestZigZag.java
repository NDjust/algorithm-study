package medium;

public class TreeLongestZigZag {
    private int result = 0;
    public int solution(Tree t) {
        if (t.l == null && t.r == null) {
            return 0;
        }

        search(t, true, false, 0);
        return result;
    }

    private void search(Tree t, boolean isRoot, boolean isRight, int zigZagCount) {
        if (t == null) {
            result = Math.max(zigZagCount - 1, result);
            return;
        }

            if (isRoot) {
                search(t.l, false, false, zigZagCount);
                search(t.r, false, true, zigZagCount);

            } else {
                if (isRight) {
                    search(t.l, false, false, zigZagCount + 1);
                    search(t.r, false, true, zigZagCount);
                } else {
                    search(t.l, false, false, zigZagCount);
                    search(t.r, false, true, zigZagCount + 1);
            }

        }
    }

    public static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}
