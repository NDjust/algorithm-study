package etc;

import java.io.*;
import java.util.ArrayList;

public class baekjoon10866 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");

            if (inputs.length == 2) {
                int value = Integer.parseInt(inputs[1]);
                if (inputs[0].equals("push_back")) {
                    arrayList.add(value);
                } else {
                    arrayList.add(0, value);
                }
            } else {
                String str = inputs[0];
                if (str.equals("front")) {
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.get(0));
                    }
                }

                if (str.equals("back")) {
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.get(arrayList.size()-1));
                    }
                }

                if (str.equals("size")) {
                    System.out.println(arrayList.size());
                }

                if (str.equals("empty")) {
                    if (arrayList.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }

                if (str.equals("pop_front")) {
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.remove(0));
                    }
                }

                if (str.equals("pop_back")) {
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.remove(arrayList.size()-1));
                    }
                }
            }
        }
    }
}
