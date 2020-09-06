package kakao.prac;

public class Traffic {

    private int[] startTimes;
    private int[] endTimes;

    public int solution(String[] lines) {
        int ans = 0;
        startTimes = new int[lines.length];
        endTimes = new int[lines.length];

        getTimes(lines);

        for (int i = 0; i < lines.length; ++i) {
            int cnt = 0;
            int start = endTimes[i];
            int end = start + 1000;

            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] >= start && startTimes[j] < end) {
                    cnt++;
                } else if (endTimes[j] >= start && endTimes[j] < end) {
                    cnt++;
                } else if (startTimes[j] <= start && endTimes[j] >= end) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    private void getTimes(String[] lines) {
        for(int i = 0 ; i < lines.length ; ++i) {
            String[] line = lines[i].split(" ");
            String[] log = line[1].split(":");
            int duration = (int) (Double.parseDouble(line[2].substring(0, line[2].length() - 1)) * 1000);
            int hour = (int) Double.parseDouble(log[0]) * 60 * 60 * 1000;
            int minutes = (int) Double.parseDouble(log[1]) * 60 * 1000;
            int second = (int) (Double.parseDouble(log[2]) * 1000);

            endTimes[i] = hour + minutes + second;
            startTimes[i] = endTimes[i] - duration + 1;
        }
    }
}
