package kakao.prac;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (final String s : cities) {
            String city = s.toLowerCase();
            if (cache.size() >= cacheSize) {
                if (cache.contains(city)) {
                    answer += 1;
                    cache.remove(city);
                } else {
                    answer += 5;
                    cache.poll();
                }

            } else {
                if (cache.contains(city)) {
                    answer += 1;
                } else {
                    answer += 5;
                }

            }
            cache.add(city);
        }
        return answer;
    }


    public static void main(String[] args) {
        int size = 3;
        String[] cities = new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        Cache cache = new Cache();

        int solution = cache.solution(size, cities);

        System.out.println(solution);
    }
}
