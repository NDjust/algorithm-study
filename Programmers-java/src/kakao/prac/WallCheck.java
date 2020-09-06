package kakao.prac;

import java.util.Arrays;

public class WallCheck {

    private int[] weak;

    private int[] dist;

    private int n;

    private int directFlag;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        Arrays.sort(weak);
        Arrays.sort(dist);

        for (int i = dist.length - 1; i >= 0; i--) {
            int maxCount = -1;
            int mStart = -1;

            for (int j = 0; j < weak.length; j++) {
                int start = weak[j];

                int count = searchCount(dist[i], start);

                if (count >= weak.length) {
                    return 1;
                } else {

                    if (maxCount < count) {
                        maxCount = count;
                        mStart = start;
                    }

                }
            }

            if (maxCount != -1) {
                visitWeak(mStart, dist[i]);
            }

        }
        return answer;
    }

    private void visitWeak(final int start, final int dist) {

    }

    private int searchCount(final int dist, final int start) {
        int clockWiseEnd = start + dist;
        int antiClockEnd = start - dist;
        int clockCnt = 0;
        int antiCnt = 0;

        if (clockWiseEnd > n) {
            int loopCount = clockWiseEnd / n;
            int next = clockWiseEnd % n;

            if (loopCount > 1) {
                return weak.length;
            } else {
                if (loopCount > 0) {
                    for (int i = start; i < clockWiseEnd - next; i++) {
                        if (containWeak(i)) {
                            clockCnt++;
                        }
                    }

                    for (int i = 0; i < next; i++) {
                        if (containWeak(i)) {
                            clockCnt++;
                        }
                    }
                }

            }
        }

        // 반 시계 방형 처리하기.
        if (antiClockEnd < 0) {
            int loopCount = Math.abs(antiClockEnd / n);
            int next = Math.abs(antiClockEnd % n);

            if (loopCount > 1) {
                return  weak.length;
            } else {
                if (loopCount > 0) {
                    for (int i = start; i < clockWiseEnd - next; i++) {
                        if (containWeak(i)) {
                            clockCnt++;
                        }
                    }

                    for (int i = 0; i < next; i++) {
                        if (containWeak(i)) {
                            clockCnt++;
                        }
                    }
                }
            }
        }

        if (clockCnt > antiCnt) {
            directFlag = 0;
        } else {
            directFlag = 1;
        }

        return Math.max(clockCnt, antiCnt);
    }

    private boolean containWeak(final int i) {
        for (int w : weak) {
            if (w == i) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WallCheck wallCheck = new WallCheck();
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        wallCheck.solution(12, weak, dist);
    }
}
