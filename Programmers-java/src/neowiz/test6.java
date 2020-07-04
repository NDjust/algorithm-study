package neowiz;

import java.util.Stack;

public class test6 {
    private static Stack<Integer> numberStack = new Stack<>();

    public static void main(String[] args) {
        String input = "6528-*2/+";
        char[] inputChars = input.toCharArray();

        for(int i=0; i<inputChars.length; i++) {
            char c = inputChars[i];

            // 피연산자이면 스택에 추가
            if(!isOperation(c)) {
                int num = Integer.parseInt(Character.toString(c));
                numberStack.push(num);
            }
            else {
                int num1 = numberStack.pop();
                int num2 = numberStack.pop();

                int result = 0 ;
                switch(c) {
                    case '+' :
                        result = num2 + num1;
                        break;
                    case '-' :
                        result = num2 - num1;
                        break;
                    case '*' :
                        result = num2 * num1;
                        break;
                    case '/' :
                        result = num2 / num1;
                        break;
                }
                numberStack.push(result);
            }

        }

        int result = numberStack.pop();
        System.out.println(result); // -9
    }

    public static boolean isOperation(char c) {
        char[] operations = {'(', ')', '*', '+', '-', '/'};
        for(int i=0; i<operations.length; i++) {
            if(c == operations[i]) {
                return true;
            }
        }
        return false;
    }




}
