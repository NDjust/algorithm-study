package etc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input.length == 2 && input[0].equals("push")) {
                list.add(Integer.parseInt(input[1]));
            } else {
                String str = input[0];
                if (str.equals("top")) {
                    bw.write(list.get(list.size()-1) + "\n");
                }

                if (str.equals("size")) {
                    bw.write(list.size() + "\n");
                }

                if (str.equals("pop")) {
                    if (!list.isEmpty()) {
                        int v = list.remove(list.size() - 1);
                        bw.write(v + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                }

                if (str.equals("empty")) {
                    if (list.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                }
            }
        }
        bw.flush();
    }
}
