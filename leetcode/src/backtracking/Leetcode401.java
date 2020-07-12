package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode401 {

    private int[] binaryHours = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    private boolean[] visitedHour = new boolean[10];

    private List<SelectedBinary> selectedBinaries = new ArrayList<>();

    private List<String> answer = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backTracking(0, num);
        Collections.sort(answer);
        return answer;
    }

    private void backTracking(int idx, final int num) {
        if (selectedBinaries.size() == num) {
            addReadTime();
            return;
        }

        for (int i = idx; i < binaryHours.length; i++) {

            if (visitedHour[i]) {
                continue;
            }

            BinaryTime binaryTime = i >= 4 ? BinaryTime.MINUTES : BinaryTime.HOUR;
            visitedHour[i] = true;
            selectedBinaries.add(new SelectedBinary(binaryHours[i], binaryTime));
            backTracking(i + 1, num);
            visitedHour[i] =false;
            selectedBinaries.remove(selectedBinaries.size()-1);
        }
    }

    private void addReadTime() {
        int hour = 0;
        int minute = 0;

        for (SelectedBinary selectedBinary : selectedBinaries) {
            int value = selectedBinary.value;
            if (selectedBinary.binaryTime.equals(BinaryTime.HOUR)) {
                hour += value;


            } else {
                minute += value;
            }
        }

        if (minute >= 60 || hour >= 12) {
            return;
        }

        if (minute == 0) {
            answer.add(String.format("%d:00", hour));
        } else if (minute < 10){
            answer.add(String.format("%d:0%d", hour, minute));
        } else {
            answer.add(String.format("%d:%d", hour, minute));
        }
    }

    private class SelectedBinary {
        int value;
        BinaryTime binaryTime;

        public SelectedBinary(final int value, final BinaryTime binaryTime) {
            this.value = value;
            this.binaryTime = binaryTime;
        }

        @Override
        public String toString() {
            return "SelectedBinary{" +
                    "value=" + value +
                    ", binaryTime=" + binaryTime +
                    '}';
        }
    }

    private enum BinaryTime {
        HOUR,
        MINUTES;
    }

    public static void main(String[] args) {
        Leetcode401 leetcode401 = new Leetcode401();
        List<String> list = leetcode401.readBinaryWatch(3);
        BinaryTime binaryTime = BinaryTime.HOUR;

        for (String s : list) {
            System.out.println(s);
        }
    }
}
