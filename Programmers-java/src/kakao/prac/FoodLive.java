package kakao.prac;

import java.util.*;

public class FoodLive {

    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();

        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(final Food f1, final Food f2) {
                return f1.time - f2.time;
            }
        });

        Iterator<Food> iterator = foods.iterator();
        int pre = 0;

        while (iterator.hasNext()) {
            int time = iterator.next().time;
            long minus = time - pre;

            if (minus != 0) {
                long diff = minus * foods.size();

                if (diff > k) {
                    break;
                }
                k -= diff;
                pre = time;
            }
            iterator.remove();
        }

        if (foods.size() == 0) {
            return -1;
        }

        k %= (long) foods.size();

        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(final Food f1, final Food f2) {
                return f1.idx - f2.idx;
            }
        });

        return foods.get((int) k).idx;
    }

    private static class Food {
        int idx;
        int time;

        public Food(final int idx, final int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        FoodLive foodLive = new FoodLive();
        int[] foodTimes = new int[] {3,1,2};
        int k = 5;
        int solution = foodLive.solution(foodTimes, k);
        System.out.println(solution);
    }
}
