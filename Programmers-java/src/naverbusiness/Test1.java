package naverbusiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public boolean solution(int[] arrA, int[] arrB) {

        List<Integer> a = Arrays.stream(arrA)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> b =  Arrays.stream(arrB)
                .boxed()
                .collect(Collectors.toList());

        if (a.equals(b)) {
            return true;
        }

        for (int i = 0; i < arrA.length; i++) {
            switchList(a);

            if (a.equals(b)) {
                return true;
            }


        }
        return false;
    }



    public void switchList(List<Integer> arrA) {
        Integer remove = arrA.remove(arrA.size() - 1);
        arrA.add(0, remove);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] arrA = {7, 8, 10};
        int[] arrB = {10, 7, 8};

        System.out.println(test1.solution(arrA, arrB));
    }
}
