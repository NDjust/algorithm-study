package naverbusiness;

import java.util.*;
import java.util.stream.Collectors;

public class Test3 {


    public int solution(int[] p) {
        int cnt = 0;

        List<Integer> sortedCards = Arrays.stream(p)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        Iterator<Integer> iterator = sortedCards.listIterator();

        while (iterator.hasNext()) {
            Integer curr = iterator.next();
            iterator.remove();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (curr < next) {
                    cnt++;
                    iterator.remove();
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] p = {3,2,1,4,5};
        System.out.println(test3.solution(p));
    }
}
