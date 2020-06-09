package practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rank {


    private boolean[] losePlayerVisited;
    private boolean[] winPlayerVisited;


    public int solution(int n, int[][] results) {
        int ans = 0;
        List<List<Integer>> losePlayerList = new ArrayList<>();
        List<List<Integer>> winnerPlayerList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            losePlayerList.add(new ArrayList<>());
            winnerPlayerList.add(new ArrayList<>());
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winnerPlayerList.get(winner).add(loser);
            losePlayerList.get(loser).add(winner);
        }

        List<Integer> pullPlayer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> losePlayers = losePlayerList.get(i);
            List<Integer> winPlayers = winnerPlayerList.get(i);
            if (losePlayers.size() + winPlayers.size() == n-1) {
                ans++;
                pullPlayer.add(i);

                for (Integer losePlayer : losePlayers) {
                    losePlayerVisited = new boolean[n+1];
                    dfs(losePlayerList, losePlayer, losePlayerVisited);
                    int rankCount = findRankCount(losePlayer, losePlayerList, losePlayerVisited);
                    if (rankCount != 0) {
                        ans += rankCount;
                        break;
                    }
                }

                for (Integer winPlayer : winPlayers) {
                    winPlayerVisited = new boolean[n+1];
                    dfs(winnerPlayerList, winPlayer, winPlayerVisited);
                    int rankCount1 = findRankCount(winPlayer, winnerPlayerList, winPlayerVisited);

                    if (rankCount1 != 0) {
                        ans += rankCount1;
                        break;
                    }
                }
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

    // TODO 노드가 끊어진 경우 찾을 수 있도록 변환.
    private void dfs(List<List<Integer>> player, int r, boolean[] visited) {

        visited[r] = true;

        for (Integer next : player.get(r)) {
            if (!visited[next]) {
                dfs(player, next, visited);
            }
        }
    }
    public static void main(String[] args) {
        Rank rank = new Rank();
        int n = 5;
        int[][] results = new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        int solution = rank.solution(n, results);
        System.out.println(solution);
    }
}
