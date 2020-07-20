package practice.dynamic;

public class TileDecoration {

    private static long[] length;

    public static long solution(int N) {
        length = new long[N];

        length[0] = 1;
        length[1] = 1;

        for (int i = 2; i < N; i++) {
            length[i] = length[i-1] + length[i-2];
        }

        return length[N-1] * 4 + length[N-2] * 2;
    }
}
