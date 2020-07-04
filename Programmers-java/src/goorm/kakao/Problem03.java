package goorm.kakao;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Map;
        import java.util.StringTokenizer;

public class Problem03 {

    public static void main(String[] args) throws IOException {
        float ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double[] snackLens = new double[n];

        for (int i = 0; i < n; i++) {
            snackLens[i] = Double.parseDouble(br.readLine());
        }


        double left = 1;
        double right = 100000;


        double snackCutCount = 0;
        while (right >= left) {
            double mid = round((right + left) / 2);
            snackCutCount = getSnackCutCount(mid, snackLens);

            if (snackCutCount < k) {
                right = round(mid - 0.01);
            } else {
                left = round(mid + 0.01);
            }

        }

        System.out.println(right);
    }

    private static double round(double value) {
        return Math.round(value*100)/100.0;
    }

    private static int getSnackCutCount(double mid, double[] snackLens) {
        int count = 0;
        for (double snackLen : snackLens) {
            count += (snackLen / mid);
        }
        return count;
    }

}
