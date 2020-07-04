package naverbusiness;

public class Test4 {

    private int[][] d;

    public int solution(int n, int capacity, int[] files) {
        int ans = 0;

        int len = files.length;

        while (n > 0) {
            for (int i = len; i > 0; i--) {
                if (isOk(capacity, files, i)) {
                    ans += i;
                }
            }
            n--;
        }

        return ans;
    }

    public boolean isOk(int capacity, int[] files, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += files[i];
        }

        return sum <= capacity;
    }



    public static void main(String[] args) {
        Test4 test4 = new Test4();

        int n = 2;
        int cap = 5;
        int[] files = {1,2,3,4,5};

        System.out.println(test4.solution(n, cap, files));
    }
}
