package kakao.prac;

public class Stone {

    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (!isPossible(stones, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isPossible(final int[] stones, final int k, final int mid) {
        int continueValue = 0;

        for (int i = 0; i < stones.length; i++) {
            int stoneValue = stones[i];
            if (stoneValue - mid <= 0) {
                continueValue++;
            } else {
                if (continueValue >= k) {
                    return false;
                }
                continueValue = 0;
            }
        }

        return continueValue < k;
    }

    public static void main(String[] args) {
        Stone stone = new Stone();
        int[] stones = new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int solution = stone.solution(stones, k);
        System.out.println(solution);
    }
}
