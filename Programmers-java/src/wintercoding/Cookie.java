package wintercoding;

public class Cookie {

    public int solution(int[] cookie) {
        int cookieCount = cookie.length;
        int result = 0;

        for (int i = 0; i < cookieCount - 1; i++) {
            // 왼쪽 시작 지점
            int left = i;
            // 오른쪽 시작 지점
            int right = i + 1;
            int leftSum = cookie[i];
            int rightSum = cookie[i + 1];


            while (true) {
                // 같으면 result Update
                if (leftSum == rightSum && result < leftSum) {
                    result = leftSum;
                    // 오른쪽 합이 왼쪽보다 크면, 왼쪽에 한 칸 이동해 더함
                } else if (leftSum <= rightSum && left != 0) {
                    leftSum += cookie[--left];
                    // 왼쪽 합이 왼쪽보다 크면, 오른쪽에 한 칸 이동해 더함
                } else if (rightSum <= leftSum && right != cookieCount - 1) {
                    rightSum += cookie[++right];
                    // 더 이상 가능하지 않은 경우
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        int[] cookies = new int[] {1, 2, 4, 5};

        int solution = cookie.solution(cookies);
        System.out.println(solution);
    }
}
