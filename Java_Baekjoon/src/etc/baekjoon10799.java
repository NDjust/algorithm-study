package etc;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon10799 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine().trim();
        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 0;
        for (int i=0; i < brackets.length(); i++){
            char c = brackets.charAt(i);
            if (c == '('){
                stack.add(i);
            } else if (c == ')'){
                if (stack.peek() == i - 1){
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
