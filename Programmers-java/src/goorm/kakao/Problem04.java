package goorm.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Problem04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, List<HashMap<String, Integer>>> hashMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());

            if (!hashMap.containsKey(s1)) {
                List<HashMap<String, Integer>> list = new ArrayList<>();

                HashMap<String, Integer> hashMap1 = new HashMap<>();
                hashMap1.put(s2, cost);
                list.add(hashMap1);
                hashMap.put(s1, list);
            } else {
                List<HashMap<String, Integer>> list = hashMap.get(s1);
                HashMap<String, Integer> hashMap1 = new HashMap<>();
                list.add(hashMap1);
            }
        }
    }
}
