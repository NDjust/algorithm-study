package practice.stack;

public class Top {

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        answer[0] = 0;
        for (int i = heights.length - 1; i > 0; i--) {
            int locTop = 0;
            for (int j = i - 1; j >= 0; j--) {

                if (heights[i] < heights[j]) {
                    locTop = j + 1;
                    break;
                }
            }
            answer[i] = locTop;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] h = {3,9,9,3,5,7,2};
        for (int i = 0; i < h.length; i++) {
            System.out.println(solution(h)[i]);
        }
    }
}
