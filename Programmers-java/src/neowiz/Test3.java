package neowiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

    public int solution(int[] p) {
        int count = 0;
        List<Integer> cards = Arrays.stream(p)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(cards);

        while (!cards.isEmpty()) {
            Integer front = cards.remove(0);

            Iterator<Integer> iterator = cards.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next > front) {
                    iterator.remove();
                    front = next;
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] p = new int[]{103,101,103,103,101,102,100,100,101,104};

        Test3 test3 = new Test3();
        System.out.println(test3.solution(p));
    }
}
