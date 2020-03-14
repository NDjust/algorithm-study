package practice.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Camouflage {

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> wearType = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (wearType.get(clothes[i][1]) == null) {
                wearType.put(clothes[i][1], 1);
            } else {
                wearType.put(clothes[i][1], wearType.get(clothes[i][1]) + 1);
            }
        }

        // 한개의 종류만 있을 경우.
        if (wearType.size() == 1) {
            return wearType.get(clothes[0][1]);
        }

        int multi = 1;

        for (int i = 0; i < clothes.length; i++) {
            if (wearType.get(clothes[i][1]) != null) {
                multi *= (wearType.remove(clothes[i][1]) + 1);
            }
        }

        return answer + multi - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                            {"blue_sunglasses", "eyewear"},
                            {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
}
