package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SocksLaundering {
    public int solution(int K, int[] C, int[] D) {
        // write your code in Java SE 8
        int result = 0;
        Map<Integer, Sock> map = new HashMap<>();

        for (int color : C) {
            Sock sock = map.getOrDefault(color, new Sock(color, 0, 0));
            sock.cleanCount++;
            if (sock.cleanCount == 2) {
                sock.cleanCount = 0;
                result++;
            }
            map.put(color, sock);
        }


        for (int color : D) {
            Sock sock = map.getOrDefault(color, new Sock(color, 0, 0));
            sock.dirtyCount++;
            map.put(color, sock);
        }

        PriorityQueue<Sock> socks = new PriorityQueue<>(new Comparator<Sock>() {
            @Override
            public int compare(Sock o1, Sock o2) {
                if (o1.cleanCount > 0 || o2.cleanCount > 0) {
                    return o2.cleanCount - o1.cleanCount;
                }

                if (o1.dirtyCount > 0 || o2.dirtyCount > 0) {
                    return o2.dirtyCount - o1.dirtyCount;
                }
                return 0;
            }
        });

        for (Integer color : map.keySet()) {
            socks.add(map.get(color));
        }

        while (!socks.isEmpty()) {
            Sock sock = socks.poll();

            if (K == 0) {
                break;
            }

            if (sock.cleanCount > 0 && sock.dirtyCount > 0) {
                sock.cleanCount--;
                sock.dirtyCount--;
                result++;
                K--;

                if (sock.dirtyCount >= 2) {
                    socks.add(sock);
                }
            } else if (sock.dirtyCount >= 2 && K >= 2) {
                K -= 2;
                sock.dirtyCount -= 2;
                result++;

                if (sock.dirtyCount >= 2) {
                    socks.add(sock);
                }
            }
        }

        return result;
    }

    public static class Sock {
        int color;
        int cleanCount;
        int dirtyCount;

        public Sock(int color, int clean, int dirty) {
            this.color = color;
            this.cleanCount = clean;
            this.dirtyCount = dirty;
        }
    }

    public static void main(String[] args) {
        SocksLaundering cleanDirtySocks = new SocksLaundering();
        int solution = cleanDirtySocks.solution(2, new int[]{1, 2, 1, 1}, new int[]{1, 4, 3, 2, 4});
        System.out.println(solution);
    }
}
