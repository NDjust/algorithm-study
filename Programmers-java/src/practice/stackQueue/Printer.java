package practice.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public static int shortCut(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }


    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> NumResultQueue = new ArrayList<>();
        ArrayList<Integer> IndexResultQueue = new ArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> IndexList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            arrayList.add(priorities[i]);
            IndexList.add(i);

        }
        boolean isLargest = true;


        while (arrayList.size() > 0) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(0) < arrayList.get(i)) {
                    int tmp = arrayList.remove(0);
                    arrayList.add(tmp);
                    tmp = IndexList.remove(0);
                    IndexList.add(tmp);
                    isLargest = false;
                    break;
                } else {
                    isLargest = true;
                }
            }

            if (isLargest){
                NumResultQueue.add(arrayList.remove(0));
                IndexResultQueue.add(IndexList.remove(0));
            }

        }

        if (!IndexList.isEmpty()) {
            IndexResultQueue.add(IndexList.remove(IndexList.size() - 1));
        }

        int len = IndexResultQueue.size();
        int loc = 0;
        while (len > 0) {
            int r = IndexResultQueue.remove(0);
            if (location == r) {
                answer = loc + 1;
                break;
            }
            loc++;
            len--;
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 3 , 2}, 2));

    }
}
