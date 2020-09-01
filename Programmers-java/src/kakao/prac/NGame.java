package kakao.prac;

import java.util.LinkedList;
import java.util.Stack;

public class NGame {

    public String solution(int n, int t, int m, int p) {
        //  진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        String answer = "";

        StringBuilder totalNumbers = new StringBuilder();
        StringBuilder currNumStr = new StringBuilder();
        int currNum = 0;
        currNumStr.append(0);

        for (int i = 0; i < m * t; i++) {
            if (currNumStr.length() > 0) {
                for (int j = 0; j < currNumStr.length(); j++) {
                    totalNumbers.append(currNumStr.charAt(j));
                }
                currNum++;
                currNumStr = toDeposition(currNum, n);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < t; i++) {
            ans.append(totalNumbers.charAt((p-1) + i * m));
        }

        return ans.toString();
    }


    public static StringBuilder toDeposition(int num, int su){
        Stack<String> stack= new Stack<>();//스택으로 사용

        StringBuilder result = new StringBuilder();

        while(num>0){

            if(num%su>9){//나머지가 10 이상일때(즉 11진수 이상일때) 문자열 배당

                stack.add(String.valueOf((char)(num%su+55)));

            }else{// 그외는 나머지 숫자값 넣기

                stack.add(String.valueOf(num%su));

            }

            num=num/su;
        }



        //스택에서 값 추출
        while(!stack.isEmpty()){
            result.append(stack.pop());

        }

        if(result.toString().equals("")) {
            result.append("0");//입력수가 0일때는 결과값 0 배당
        }

        return result;

    }

    public static void main(String[] args) {
        NGame nGame = new NGame();
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;

        String solution = nGame.solution(n, t, m, p);
        System.out.println(solution.toString());
    }
}
