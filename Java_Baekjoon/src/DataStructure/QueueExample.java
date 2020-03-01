package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

/*baekjoon algorithms
* https://www.acmicpc.net/problem/10845 */
public class QueueExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> queue = new ArrayList<Integer>();

        int num = Integer.parseInt(sc.nextLine());

        for (int i=0; i < num; i++){

            String[] line = sc.nextLine().split(" ");
            String cmd = line[0];

            if(cmd.equals("push")){

                queue.add(Integer.parseInt(line[1]));

            }else if (cmd.equals("pop")){

                if (queue.size() == 0){

                    System.out.println("-1");

                }else {

                    System.out.println(queue.remove(0));

                }

            }else if (cmd.equals("size")){

                System.out.println(queue.size());

            }else if (cmd.equals("empty")) {

                if (queue.size() == 0){

                    System.out.println(1);

                } else{

                    System.out.println(0);

                }

            }else if (cmd.equals("front")){

                if (queue.size() == 0){

                    System.out.println(-1);

                }else {

                    System.out.println(queue.get(0));

                }

            }else if (cmd.equals("back")){

                if (queue.size() == 0){

                    System.out.println(-1);

                }else {

                    System.out.println(queue.get(queue.size() - 1));

                }
            }

        }

    }
}
