import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int n = 6;
        String u[] = {"Pan", "Olivia", "Luna", "Sophie", "Mint", "Dina"};
        int s[] = {100, 200, 300, 200, 300, 200};
        int t[] = {10, 20, 20, 10, 30, 10};

        List<UserInfo> userInfos = new ArrayList<>();

        for (int i = 0; i < u.length; i++) {
            userInfos.add(new UserInfo(u[i], i, s[i],t[i]));
        }

        Collections.sort(userInfos);
        for (UserInfo userInfo : userInfos) {
            userInfo.printUserInfo();
        }
    }

    static class UserInfo implements Comparable<UserInfo> {
        String id;
        int idx;
        int score;
        int time;

        public UserInfo(final String id, final int idx, final int score, final int time) {
            this.id = id;
            this.idx = idx;
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(final UserInfo userInfo) {
            // score에 대해서 내림차순
            if (this.score > userInfo.score) {
                return -1;
            } else if (score == userInfo.score) {
                if (this.time < userInfo.time) { // time에 대해서 오름차순
                    return -1;
                }
            }
            if (idx < userInfo.idx) { // idx에 대해서 내림차순
                return -1;
            }
            return 1;
        }

        public void printUserInfo() {
            System.out.println(String.format("%s %d %d", id, score, time));
        }
    }
}
