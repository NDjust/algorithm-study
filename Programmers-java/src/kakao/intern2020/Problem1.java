package kakao.intern2020;

public class Problem1 {
    static int[][] keypad = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10,0,11}};
    static int[] leftLoc = {3, 0};
    static int[] rightLoc = {3, 2};
    static int[] leftNumber = {1, 4, 7};
    static int[] rightNumber = {3, 6, 9};
    static int[] medianNumber = {2, 5, 8, 0};
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int minDist;

    public static int[] getNumberLoc(int num) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static boolean isLeftNumber(int num) {
        for (int i : leftNumber) {
            if (num == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRightNumber(int num) {
        for (int i : rightNumber) {
            if (num == i) {
                return true;
            }
        }
        return false;
    }

    public static void findNumDistance(int num, int i, int j, int dist) {
        if (keypad[i][j] == num) {
            if (minDist > dist) {
                minDist = dist;
            }
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int mx = dx[k] + i;
            int my = dy[k] + j;

            if (mx >= 0 && my >= 0 && mx < keypad.length && my < keypad[0].length) {
                if (!visited[mx][my]) {
                    findNumDistance(num, mx, my, dist+1);
                }
            }
        }
        return;
    }


    public static String solution(int[] numbers, String hand) {
        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            if (isLeftNumber(numbers[i])) {
                leftLoc = getNumberLoc(numbers[i]);
                answer += "L";
            } else if (isRightNumber(numbers[i])) {
                rightLoc = getNumberLoc(numbers[i]);
                answer += "R";
            } else {
                minDist = Integer.MAX_VALUE;
                visited = new boolean[keypad.length][keypad[0].length];
                findNumDistance(numbers[i], leftLoc[0], leftLoc[1], 0);
                int leftFindDistance = minDist;
                System.out.printf("left dist : %d\n", leftFindDistance);
                minDist = Integer.MAX_VALUE;
                visited = new boolean[keypad.length][keypad[0].length];
                findNumDistance(numbers[i], rightLoc[0], rightLoc[1], 0);
                int rightFindDistance = minDist;
                System.out.printf("right dist : %d\n", rightFindDistance);
                if (leftFindDistance > rightFindDistance) {
                    rightLoc = getNumberLoc(numbers[i]);
                    answer += "R";
                } else if (rightFindDistance > leftFindDistance) {
                    leftLoc = getNumberLoc(numbers[i]);
                    answer += "L";
                } else {
                    if (hand.equals("right")) {
                        rightLoc = getNumberLoc(numbers[i]);
                        answer += "R";
                    } else {
                        leftLoc = getNumberLoc(numbers[i]);
                        answer += "L";
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
