package greedy;

import java.util.Arrays;

public class Leetcode881 {

    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int i = 0;
       int j = people.length - 1;
       int ans = 0;

       while (i <= j) {
           ans++;

           if (people[i] + people[j] <= limit) {
               i++;
           }

           j--;
       }

       return ans;
    }

    public static void main(String[] args) {
        Leetcode881 leetcode881 = new Leetcode881();
        int[] people = {5, 1, 4, 2};
        int limit = 6;

        int i = leetcode881.numRescueBoats(people, limit);
        System.out.println(i);
    }
}
