import java.util.*;

public class Test3 {

    private static boolean[] userMatching;

    public static void main(String[] args) {
        int n = 5;
        userMatching = new boolean[n + 1];
        int [][] m = {
                {1, 342},
                {2, 538},
                {3, 624},
                {4, 984},
                {5, 525},
        };

        List<DiffInfo> diffInfoList = new ArrayList<>();

        for (int i = 0; i < m.length-1; i++) {
            for (int j = i+1; j < m.length; j++) {
                int diff = Math.abs(m[i][1] - m[j][1]);
                diffInfoList.add(new DiffInfo(i+1, j+1, diff));
            }
        }

        // 차이 점수로 정렬 후 매칭된 유저들 pop 하면서 매칭할 수 없는 경우까지
        Collections.sort(diffInfoList);
        List<DiffInfo> results = new ArrayList<>();
        DiffInfo first = diffInfoList.remove(0);
        userMatching[first.getUserIdOne()] = true;
        userMatching[first.getUserIdTwo()] = true;

        results.add(first);

        for (DiffInfo diffInfo : diffInfoList) {
            int userIdOne = diffInfo.getUserIdOne();
            int userIdTwo = diffInfo.getUserIdTwo();

            if (!userMatching[userIdOne] && !userMatching[userIdTwo]) {
                userMatching[userIdOne] = true;
                userMatching[userIdTwo] = true;
                diffInfoList.remove(diffInfo);
            }
        }

        for (DiffInfo result : results) {
            result.printMatch();
        }

    }

    static class DiffInfo implements Comparable<DiffInfo> {
        int userIdOne;
        int userIdTwo;
        int diffScore;

        public DiffInfo(final int userIdOne, final int userIdTwo, final int diffScore) {
            this.userIdOne = userIdOne;
            this.userIdTwo = userIdTwo;
            this.diffScore = diffScore;
        }

        @Override
        public int compareTo(final DiffInfo diffInfo) {
            if (diffScore < diffInfo.diffScore) {
                return -1;
            }
            return 1;
        }

        public void printMatch() {
            if (userIdOne < userIdTwo) {
                System.out.println(String.format("%d %d", userIdOne, userIdTwo));
            } else {
                System.out.println(String.format("%d %d", userIdTwo, userIdOne));
            }
        }
        @Override
        public String toString() {
            return "DiffInfo{" +
                    "userIdOne=" + userIdOne +
                    ", userIdTwo=" + userIdTwo +
                    ", diffScore=" + diffScore +
                    '}';
        }

        public int getUserIdOne() {
            return userIdOne;
        }

        public int getUserIdTwo() {
            return userIdTwo;
        }

        public int getDiffScore() {
            return diffScore;
        }
    }
}
