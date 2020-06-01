package practice.dynamic;

public class SchoolRoad {

    private static int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
         // d[x][y] = x, y에 올 수 있는 경로의 개수. (d[x-1][y], d[x][y-1]에서 올 수 있음)
        int[][] d = new int[m+1][n+1];

        for (int[] puddle : puddles) {
            d[puddle[0]][puddle[1]] = -1;
        }
        d[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 웅덩이인 경우 올 수 있는 경로 0
                if (d[i][j] == -1) {
                    d[i][j] = 0;
                    continue;
                }

                // 위에서 올 경우
                if (i != 1) {
                    d[i][j] += d[i-1][j] % MOD;
                }

                // 왼쪽에서 올 경우
                if (j != 1) {
                    d[i][j] += d[i][j-1] % MOD;
                }
            }
        }
        return d[m][n] % MOD;
    }
}