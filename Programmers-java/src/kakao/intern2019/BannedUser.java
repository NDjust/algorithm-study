package kakao.intern2019;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BannedUser {

    private static boolean[] visited;
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<HashSet> result = new ArrayList<>();
    private static HashSet<String> hashSet;

    public static int solution(String[] user_id, String[] banned_id) {
        Arrays.sort(banned_id);
        visited = new boolean[user_id.length];
        result = new ArrayList<>();
        list = new ArrayList<>();
        dfs(user_id, banned_id, 0);

        int ans = hashSet.size();
        return ans;
    }

    private static void dfs(String[] user_id, String[] banned_id, int idx) {
        if (idx == banned_id.length) {
            hashSet = new HashSet<>();
            hashSet.addAll(list);
            boolean flag = true;

            for (HashSet set : result) {
                if (set.containsAll(list)) {
                    flag = false;
                }
            }

            if (flag) {
                result.add(hashSet);
            }

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (isEqual(user_id[i], banned_id[idx]) && !visited[i]) {
                list.add(user_id[i]);
                visited[i] = true;
                dfs(user_id, banned_id, idx+1);
                visited[i] = false;
                list.remove(idx);
            }
        }
    }

    private static boolean isEqual(String user, String bannedUser) {
        Pattern pattern = Pattern.compile(bannedUser.replace("*", "."));
        Matcher matcher = pattern.matcher(user);
        return user.length() == bannedUser.length() &&
                matcher.matches();
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        System.out.println(solution(user_id, banned_id));
    }
}
