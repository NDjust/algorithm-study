package easy;

public class TreeHeight {
    public int solution(Tree T) {
        if (T == null) {
            return -1;
        }

        return search(0, T);
    }

    private int search(int count, Tree t) {
        if (t == null) {
            return count - 1;
        }
        return Math.max(search(count + 1, t.l), search(count + 1, t.r));
    }

    public static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}
