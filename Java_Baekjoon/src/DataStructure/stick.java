package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class stick {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 0;

        for (int i=0; i < brackets.length(); i++){

            char c = brackets.charAt(i);

            if (c == '('){ /* '' -> char ""-> String*/

                stack.add(i);

            } else if (c == ')'){

                if (stack.peek() + 1== i ){

                    stack.pop();

                    cnt += stack.size();

                } else{

                    stack.pop();

                    cnt += 1;

                }
            }
        }
        System.out.println(cnt);
    }
}
