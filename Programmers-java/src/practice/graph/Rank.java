package practice.graph;

import java.util.*;

public class Rank {

    private int INF = 987654321;

    // https://iamheesoo.github.io/blog/algo-prog49191
    public int floydWarshallAlgorithms(int n, int[][] results) {
        int answer = 0;
        int[][] scores = new int[n+1][n+1];
        int win, lose;

        for (int[] score : scores) {
            Arrays.fill(score, INF);
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (i == j) {
                    scores[i][j] = 0;
                }
            }
        }


        for (int[] result : results) {
            win = result[0];
            lose = result[1];
            scores[win][lose] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (scores[j][k] > scores[j][i] + scores[i][k]) {
                        scores[j][k] = scores[j][i] + scores[i][k];
                    }
                }
            }
        }


        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (scores[i][j] == INF && scores[j][i] == INF) {
                    flag[i] = false;
                    break;
                }
            }
        }

        for (int i = 1; i < flag.length; i++) {
            if (flag[i]) {
                answer++;
            }
        }
        return answer;
    }

    public int solution(int n, int[][] results) {
        int ans = 0;
        List<HashSet<Integer>> losePlayerList = new ArrayList<>();
        List<HashSet<Integer>> winnerPlayerList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            losePlayerList.add(new HashSet<>());
            winnerPlayerList.add(new HashSet<>());
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winnerPlayerList.get(winner).add(loser);
            losePlayerList.get(loser).add(winner);
        }

        for (int i = 1; i <= n; i++) {
            if (losePlayerList.get(i).size() + winnerPlayerList.get(i).size() == n - 1) {
                ans++;
            }
        }

        return ans;
    }

    private int findRankCount(int r, List<List<Integer>> player, boolean[] visited) {
        for (Integer next : player.get(r)) {
            if (!visited[next]) {
                return 0;
            }
        }
        return player.get(r).size();
    }


    public static void main(String[] args) {
        Rank rank = new Rank();
        int n = 5;
        int[][] results = new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        int solution = rank.solution(n, results);
        System.out.println(rank.floydWarshallAlgorithms(n, results));
    }
}
