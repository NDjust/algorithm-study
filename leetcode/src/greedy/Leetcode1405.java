package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1405 {

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Alphabet> priorityQueue = new PriorityQueue<>();

        if (a > 0) {
            priorityQueue.add(new Alphabet('a', a));
        }

        if (b > 0) {
            priorityQueue.add(new Alphabet('b', b));
        }

        if (c > 0) {
            priorityQueue.add(new Alphabet('c', c));
        }

        StringBuilder sb = new StringBuilder();

        while (priorityQueue.size() > 1) {
            Alphabet one = priorityQueue.poll();
            char alphabet = one.alphabet;

            if (one.count > 1) {
                sb.append(alphabet);
                sb.append(alphabet);
                one.decreaseCount(2);
            } else {
                sb.append(alphabet);
                one.decreaseCount(1);
            }

            Alphabet two = priorityQueue.poll();

            if (two.count > 1 && two.count > one.count) {
                sb.append(two.alphabet);
                sb.append(two.alphabet);
                two.decreaseCount(2);
            } else {
                sb.append(two.alphabet);
                two.decreaseCount(1);
            }

            if (one.count > 0) {
                priorityQueue.add(one);
            }

            if (two.count > 0) {
                priorityQueue.add(two);
            }
        }

        if (!priorityQueue.isEmpty()) {
            Alphabet poll = priorityQueue.poll();

            if (poll.count > 1 && poll.alphabet != sb.charAt(sb.length()-1)) {
                sb.append(poll.alphabet);
                sb.append(poll.alphabet);
            } else {
                sb.append(poll.alphabet);
            }
        }

        return sb.toString();
    }

    private static class Alphabet implements Comparable<Alphabet> {
        char alphabet;
        int count;

        public Alphabet(final char alphabet, final int count) {
            this.alphabet = alphabet;
            this.count = count;
        }

        public void decreaseCount(int cnt) {
            this.count -= cnt;
        }

        @Override
        public int compareTo(final Alphabet alphabet) {
            return alphabet.count - this.count;
        }
    }

    public static void main(String[] args) {
        Leetcode1405 leetcode1405 = new Leetcode1405();

        String s = leetcode1405.longestDiverseString(7, 1, 0);
        System.out.println(s);
    }
}
