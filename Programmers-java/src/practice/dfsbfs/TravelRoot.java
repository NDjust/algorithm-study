package practice.dfsbfs;

import java.util.*;

public class TravelRoot {

    private static boolean[] visited;
    private static List<Stack<String>> pathList;
    private static Stack<String> root;
    public static String[] solution(String[][] tickets) {
       pathList = new ArrayList<>();
       visited = new boolean[tickets.length];
       root = new Stack<>();
       root.push("ICN");

       dfs(tickets, root, 0);

       Collections.sort(pathList, new Comparator<Stack<String>>() {
           @Override
           public int compare(Stack<String> t1, Stack<String> t2) {
               for (int i = 0; i < t1.size(); i++) {
                   if (!t1.get(i).equals(t2.get(i))) {
                       return t1.get(i).compareTo(t2.get(i));
                   }
               }
               return 0;
           }
       });

        Stack<String> ans = pathList.get(0);
        String[] answer = new String[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    private static void dfs(String[][] tickets, Stack<String> root, int len) {
        if (len == tickets.length) {
            Stack<String> result = new Stack<>();
            result.addAll(root);
            pathList.add(result);
            return;
        };

        String peek = root.peek();

        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            if (peek.equals(start) && !visited[i]) {
                visited[i] = true;
                root.push(end);
                dfs(tickets, root, len + 1);
                visited[i] = false;
                root.pop();
            }
        }
    }

    public static void main(String[] args) {
        String[] solution = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});

        for (String s : solution) {
            System.out.printf(s + ", ");
        }

    }
}
