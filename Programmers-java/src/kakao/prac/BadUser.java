package kakao.prac;

import java.util.*;

public class BadUser {

    private boolean[] visited;
    private boolean[] banVisited;

    private Set<BanList> banIdList = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        visited = new boolean[user_id.length];
        banVisited = new boolean[banned_id.length];

        backTracking(user_id, banned_id, new BanList());

        return banIdList.size();
    }

    private void backTracking(final String[] user_id, final String[] banned_id, final BanList currList) {

        if (currList.size() == banned_id.length) {
            if (!banIdList.contains(currList)) {
                System.out.println(currList.banList.toString());
                banIdList.add(currList);
            }

            return;
        }

        for (int j = 0; j < banned_id.length; j++) {
            for (int i = 0; i < user_id.length; i++) {
                if (banned_id[j].length() == user_id[i].length() && isPossible(user_id[i], banned_id[j])) {
                    if (!visited[i] && !banVisited[j]) {
                        visited[i] = true;
                        banVisited[j] = true;
                        currList.add(user_id[i]);
                        backTracking(user_id, banned_id, currList);
                        currList.remove(user_id[i]);
                        visited[i] = false;
                        banVisited[j] = false;
                    }
                }

            }
        }
    }


    public boolean isPossible(String user, String banId) {
        for (int i = 0; i < user.length(); i++) {
            char u = user.charAt(i);
            char b = banId.charAt(i);

            if (b == '*') {
                continue;
            }

            if (u != b) {
                return false;
            }
        }

        return true;
    }

    private static class BanList {
        Set<String> banList = new HashSet<>();

        public BanList() {
        }

        public void add(String user) {
            banList.add(user);
        }

        public void remove(String s) {
            banList.remove(s);
        }

        public int size() {
            return banList.size();
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final BanList banList1 = (BanList) o;
            return Objects.equals(banList, banList1.banList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(banList);
        }
    }

    public static void main(String[] args) {
        BadUser badUser = new BadUser();
        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id = new String[]{"fr*d*", "abc1**"};
        badUser.solution(user_id, ban_id);
    }


}
