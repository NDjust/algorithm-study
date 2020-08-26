package kakao.prac;

import java.util.*;
import java.util.stream.IntStream;

public class FailRate {

    public int[] solution(int N, int[] stage) {
        int[] answer = new int[N];
        List<Stage> stages = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stages.add(new Stage(i + 1));
        }

        for (int num : stage) {

            if (num > stages.size()) {
                continue;
            }

            Stage stage1 = stages.get(num - 1);
            stage1.increaseFailCount();
        }

        Stage head = stages.get(0);
        head.tryCount = stage.length;;

        for (int i = 1; i < stages.size(); i++) {
            Stage previousStage = stages.get(i - 1);
            Stage currStage = stages.get(i);
            currStage.tryCount = previousStage.tryCount - previousStage.failCount;

        }


        for (Stage stage1 : stages) {
            stage1.calculateFailRate();
        }

        stages.sort((s1, s2) -> {
            if (s1.failRate.equals(s2.failRate)) {
                return s1.stageNum - s2.stageNum;
            }
            return Double.compare(s2.failRate, s1.failRate);
        });

        for (int i = 0; i < stages.size(); i++) {
            answer[i] = stages.get(i).stageNum;
        }

        return answer;
    }

    private static class Stage {
        int stageNum;
        double tryCount;
        double failCount;
        Double failRate;

        public Stage(final int stageNum) {
            this.stageNum = stageNum;
        }

        public void increaseFailCount() {
            failCount++;
        }

        public void calculateFailRate() {
            if (failCount == 0) {
                this.failRate = (double) 0;
            } else {
                this.failRate = failCount / tryCount;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] stages = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
        FailRate failRate = new FailRate();

        int[] solution = failRate.solution(n, stages);
        System.out.println(Arrays.toString(solution));
    }
}
