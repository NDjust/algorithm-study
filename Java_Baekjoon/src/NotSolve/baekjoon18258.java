package NotSolve;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ArrayQueue {
    ArrayList<Integer> q;
    public ArrayQueue() {
        this.q = new ArrayList<Integer>();
    }

    public void push (int a) {
        if (q.size() == 0) {
            q.add(0, a);
        } else {
            q.add(q.size(), a);
        }
    }

    public int pop () {
        if (q.size() == 0) {
            return -1;
        }

        return q.remove(0);
    }

    public int size() {
        return q.size();
    }

    public int isEmpty() {
        if (q.size() == 0) {
            return 1;
        }
        return 0;
    }

    public int front() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.get(0);
    }

    public int back() {
        if (q.isEmpty()) {
            return -1;
        }

        return q.get(q.size() - 1);
    }
}

public class baekjoon18258 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayQueue q = new ArrayQueue();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            String s = sc.next();

            if (s.equals("push")) {
                int a = sc.nextInt();
                q.push(a);
            }

            if (s.equals("pop")) {
                sb.append(q.pop() + "\n");
            }

            if (s.equals("size")) {
                sb.append(q.size() + "\n");
            }

            if (s.equals("empty")) {
                sb.append(q.isEmpty() + "\n");
            }

            if (s.equals("front")) {
                sb.append(q.front() + "\n");
            }

            if (s.equals("back")) {
                sb.append(q.back() + "\n");
            }
        }
        System.out.println(sb);
    }
}
