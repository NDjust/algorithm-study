package DataStructure;/* baekjoon 1406
https://www.acmicpc.net/problem/1406
Time error*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Editor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int num = sc.nextInt();

        sc.nextLine();

        Stack<Character> right = new Stack<Character>();
        Stack<Character> left = new Stack<Character>();

        for (int i=0; i < str.length(); i++){

            left.push(str.charAt(i));

        }

        for (int j=0; j < num; j++){

            String[] line = sc.nextLine().split(" ");
            String cmd = line[0];

            if (cmd.equals("P")){

                left.push(line[1].charAt(0));

            }else if (cmd.equals("L")){

                if(!left.empty()){

                    right.push(left.pop());

                }

            }else if (cmd.equals("D")){

                if (!right.empty()){

                    left.push(right.pop());

                }

            }else if (cmd.equals("B")){

                if (!right.empty()) {

                    left.pop();

                }
            }
        }
//        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        while(!left.empty()){

            right.push(left.pop());

        }

        while (!right.empty()) {

            sb.append(right.pop());

        }

        System.out.println(sb);

    }

}
