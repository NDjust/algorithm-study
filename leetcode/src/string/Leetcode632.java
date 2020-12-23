package string;

import java.util.List;
import java.util.PriorityQueue;

public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int minx = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;

        // 우선순위 큐로 최소값 효율적으로 저장 및 추출
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[0] - j[0]);

        for (int i = 0; i < nums.size(); i++) {
            // 각 리스트의 시작위치에서 최대값 추출
            if (nums.get(i).get(0) > maxy) {
                maxy = nums.get(i).get(0);
            }

            // 각 리스트의 시작위치와 시작위치 값 저장
            pq.offer(new int[] {nums.get(i).get(0), i, 0});
        }

        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int i = min[1];
            int j = min[2];

            // 현재 각 리스트 위치에서 (최대 - 최소), (현재 최소 Range 값) 비교 후 갱신
            if (maxy - min[0] < minRange) {
                minRange = maxy - min[0];
                res[0] = min[0];
                res[1] = maxy;
            }

            // 최소 값을 가지고 있는 리스트 한칸 이동
            if (i < nums.size() && j + 1 < nums.get(i).size()) {
                pq.offer(new int[] {nums.get(i).get(j + 1), i, j + 1});

                // 현재 최대값보다 크면 갱신
                if (nums.get(i).get(j + 1) > maxy) {
                    maxy = nums.get(i).get(j + 1);
                }
            } else {
                break;
            }
        }
        return res;
    }

}
