package string;

import java.io.*;
import java.util.*;

public class Baekjoon4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        int totalCount = 0;
        String input = "";

        while ((input=br.readLine())!=null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            totalCount++;
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);


        StringBuilder sb = new StringBuilder();

        for (Object key : keys) {
            String mapKey = (String) key;
            Integer value = map.get(mapKey);
            bw.write(String.format("%s %.4f\n", mapKey, (double) (value * 100.0) / totalCount));
        }
        bw.flush();
    }

}
