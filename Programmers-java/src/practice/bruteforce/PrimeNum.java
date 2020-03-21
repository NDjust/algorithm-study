package practice.bruteforce;

import java.util.LinkedList;

public class PrimeNum {
    static int numberArray[];
    static int ans[] = new int[9999999];
    static int answer = 0;


    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i ++) {
            if ((n%i) == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers) {
        numberArray = new int[numbers.length()];
        for(int i=0; i<numberArray.length; i++){
            numberArray[i] = Integer.parseInt(numbers.charAt(i)+"");
        }

        int n = numberArray.length;
        for(int i=1; i<=numberArray.length; i++){
            LinkedList<Integer> perArr = new LinkedList<Integer>();
            int[] perCheck = new int[n];
            permutation(n, i, perArr, perCheck);
        }

        return answer;
    }

    //순열 (순서있게 배열)
    private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {
        if(perArr.size() == r){
            String tmpNum ="";
            for(int i : perArr){
                //System.out.print(numberArray[i]+" ");
                tmpNum += numberArray[i]+"";
            }

            if(ans[Integer.parseInt(tmpNum)] == 0){
                //소수 판별 로직 수행
                // 0 미수행, 1소수아님, 2소수임
                if(isPrime(Integer.parseInt(tmpNum))){
                    answer++;
                }
            }
            //수행
            ans[Integer.parseInt(tmpNum)] = 1;

            return;
        }

        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(i);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }

    }
}