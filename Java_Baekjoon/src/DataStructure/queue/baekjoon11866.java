package DataStructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");

        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i=1; i<=Integer.parseInt(nums[0]); i ++){
            queue.add(i);
        }

        for (int j = 0; j < Integer.parseInt(nums[0]); j++){
            for (int k = 1; k < Integer.parseInt(nums[1]); k++){
                queue.add(queue.remove());
            }
            result.add(queue.remove());
        }

        System.out.print('<');

        for (int l=0; l < result.size(); l++){
            System.out.print(result.get(l));
            if (l == result.size() - 1){
                break;
            }
            System.out.print(", ");
        }
        System.out.print(">");
    }
}
