package practice.hash;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UncompletedPeople {



    public static String solution(String[] participant, String[] completion) {
        String answer = ""; //초기화값
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i<completion.length;i++){
            if(participant[i].equals(completion[i])){
                continue;
            }else if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            answer = participant[participant.length-1];
        }
        return answer;
    }
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"mislav", "stanko", "ana"}));
    }
}
