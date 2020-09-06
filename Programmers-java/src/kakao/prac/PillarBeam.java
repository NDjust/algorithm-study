package kakao.prac;

public class PillarBeam {

    private static final int PILLAR = 0;
    private static final int BEAM = 1;
    private static final int DECONSTRUCT = 0;
    private static final int CONSTRUCT = 1;

    private boolean[][] pillar;
    private boolean[][] beam;

    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 3][n + 3];
        beam = new boolean[n + 3][n + 3];
        int constructCount = 0;

        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int structType = frame[2];
            int commandType = frame[3];


            if (commandType == CONSTRUCT) {
                if (structType == PILLAR) {
                    if (canConstructPillar(x, y)) {
                        pillar[x][y] = true;
                        constructCount++;
                    }
                } else {
                    if (canConstructBeam(x, y)) {
                        beam[x][y] = true;
                        constructCount++;
                    }
                }
            } else {
                if (structType == PILLAR) {
                    pillar[x][y] = false;
                } else {
                    beam[x][y] = false;
                }

                if (canDeconstruct(x, y, structType, n)) {
                    constructCount--;
                    continue;
                }

                if (structType == PILLAR) {
                    pillar[x][y] = true;
                } else {
                    beam[x][y] = true;
                }
            }
        }

        int[][] ans = new int[constructCount][n];
        int idx = 0;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillar[i][j]) {
                    ans[idx++] = new int[] {i - 1, j - 1, PILLAR};
                }

                if (beam[i][j]) {
                    ans[idx++] = new int[] {i - 1, j - 1, BEAM};
                }
            }
        }

        return ans;
    }

    private boolean canDeconstruct(final int x, final int y, final int structType, final int n) {
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillar[i][j] && !canConstructPillar(i, j)) {
                    return false;
                }
                if (beam[i][j] && !canConstructBeam(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canConstructBeam(final int x, final int y) {
        return pillar[x][y-1] || pillar[x+1][y-1] || (beam[x-1][y] && beam[x+1][y]);
    }

    private boolean canConstructPillar(final int x, final int y) {
        return y == 1 || beam[x][y] || beam[x-1][y] || pillar[x][y-1];
    }
}
