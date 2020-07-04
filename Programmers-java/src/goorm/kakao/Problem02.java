package goorm.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int teamCount = Integer.parseInt(br.readLine());
        int gameCount = teamCount * (teamCount - 1);

        HashMap<String, Team> teams = new LinkedHashMap<>();

        for (int i = 0; i < gameCount; i++) {
            String[] inputs = br.readLine().split(" ");
            String team1 = inputs[0];
            int team1WinCount = Integer.parseInt(inputs[1]);
            String team2 = inputs[2];
            int team2WinCount = Integer.parseInt(inputs[3]);
            boolean team1Win = team1WinCount > team2WinCount;
            boolean team2Win = team1WinCount < team2WinCount;

            setTeam((HashMap<String, Team>) teams, team1WinCount, team1, team2WinCount, team1Win);
            setTeam((HashMap<String, Team>) teams, team2WinCount, team2, team1WinCount, team2Win);
        }

        Iterator<String> iterator = sortByValue(teams).iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            Team team = teams.get(next);
            System.out.println(String.format("%s %d %d", next, team.winCount, team.getSetResult()));
        }
    }

    private static List sortByValue(final Map<String, Team> map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                Team o1 = map.get(t1);
                Team o2 = map.get(t2);

                if (o1.winCount == o2.winCount && o1.getSetResult() == o2.getSetResult()) {
                    return t1.compareTo(t2);
                }

                if (o1.winCount == o2.winCount) {
                    return o2.getSetResult() - o1.getSetResult();
                }

                return o2.winCount - o1.winCount;
            }
        });

        return list;
    }

    private static void setTeam(HashMap<String, Team> teams, int team1WinCount, String targetTeam, int team2WinCount, boolean team1Win) {
        if (!teams.containsKey(targetTeam)) {
            Team team = new Team();

            // set setCount
            team.addSetWin(team1WinCount);
            team.addSetLose(team2WinCount);

            if (team1Win) {
                team.addWinCount();
            } else {
                team.addLoseCount();
            }

            teams.put(targetTeam, team);
        } else {
            Team team = teams.get(targetTeam);

            // set setCount
            team.addSetWin(team1WinCount);
            team.addSetLose(team2WinCount);

            if (team1Win) {
                team.addWinCount();
            } else {
                team.addLoseCount();
            }
        }
    }

    static class Team {
        String teamName;
        int winCount = 0;
        int loseCount = 0;
        int setWin = 0;
        int setLose = 0;


        public void addWinCount() {
            winCount++;
        }

        public void addLoseCount() {
            loseCount++;
        }

        public void addSetWin(int count) {
            setWin += count;
        }

        public void addSetLose(int count) {
            setLose += count;
        }

        public int getSetResult() {
            return setWin - setLose;
        }
    }
}
