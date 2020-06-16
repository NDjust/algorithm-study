package practice.greedy;

public class MaxNumber {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int index = 0;
        int len = sb.length();
        int current = 0;
        int next = 0;
        while (k > 0) {
            if (len - 1 == index) {
                return sb.substring(0, len - k);
            } else {
                index++;
                current = (int) sb.charAt(index - 1) - '0';
                next = (int) sb.charAt(index) - '0';

                if (next > current) {
                    sb.delete(index - 1, index);
                    len = sb.length();
                    index = 0;
                    k--;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();

        System.out.println(maxNumber.solution("1231234", 3));
    }
}
