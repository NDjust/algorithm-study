package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoormStack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stack = new int[10];
        int count = Integer.parseInt(br.readLine());
        int currentIdx = -1;
        for (int i = 0; i < count; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                int num = Integer.parseInt(br.readLine());
                if (currentIdx + 1 >= 10) {
                    System.out.println("overflow");
                } else {
                    stack[++currentIdx] = num;
                }
            } else if (command == 1) {
                if (currentIdx < 0) {
                    System.out.println("underflow");
                } else {
                    stack[currentIdx--] = 0;
                }
            } else {
                break;
            }

        }

        if (currentIdx >= 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= currentIdx; i++) {
                sb.append(stack[i]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
