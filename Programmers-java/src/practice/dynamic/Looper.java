package practice.dynamic;

public class Looper {

    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int[] d1 = new int[n-1];
        int[] d2 = new int[n];

        d1[0] = money[0];
        d1[1] = money[0];
        d2[0] = 0;
        d2[1] = money[1];

        for (int i = 2; i < n-1; i++) {
            d1[i] = Math.max(d1[i-2] + money[i], d1[i-1]);
        }

        for (int i = 2; i < n; i++) {
            d2[i] = Math.max(d2[i-2] + money[i], d2[i-1]);
        }
        answer = Math.max(d1[n-2], d2[n-1]);
        return answer;
    }

    public static void main(String[] args) {

    }
}
