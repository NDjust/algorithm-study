import java.util.*;

public class Test2 {
    public static void main(String[] args){
        int n = 3;
        int [][] m = {
                {1, 10},
                {2, 30},
                {3, 60},
        };

        Map<Integer, Double> weights = new HashMap<>();
        for (int[] info : m) {
            weights.put(info[0], (double) info[1]);
        }

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.print(getWeightedRandom(weights, random) + " ");
        }
    }

    public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        for (E element : weights.keySet()) {
            double value = -Math.log(random.nextDouble()) / weights.get(element);
            if (value < bestValue) {
                bestValue = value;
                result = element;
            }
        }
        return result;
    }
}
