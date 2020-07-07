package practice.bruteforce;


public class Capet {

    public int[] solution(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = brown + yellow;
        return new int[]{(int)(a + Math.sqrt(a*a-4*b)) / 2, (int)(a - Math.sqrt(a*a - 4*b)) / 2};
    }

    public static void main(String[] args) {
        Capet capet = new Capet();
        capet.solution(24, 24);
    }
}
