package practice.stackQueue;

public class StockPrice {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int k = 0;
        for (int i = 0; i < answer.length - 1; i++) {
            int sec = 0;

            for (int j = i + 1; j < answer.length; j++) {
                sec++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[k++] = sec;
        }

        return answer;
    }
    public static void main(String[] args) {

        int[] p = {1, 2, 3, 2, 3};
        int[] ans = solution(p);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
