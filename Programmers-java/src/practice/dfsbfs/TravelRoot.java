package practice.dfsbfs;

import java.util.*;

public class TravelRoot {

    private List<List<String>> travelRoots = new ArrayList<>();

    private boolean[] useTicket;

    private int ticketCount;

    public String[] solution(String[][] tickets) {
        useTicket = new boolean[tickets.length];
        ticketCount = tickets.length;

        List<String> root = new ArrayList<>();
        root.add("ICN");
        dfs("ICN", root, tickets, 0);

        travelRoots.sort(new Comparator<List<String>>() {
            @Override
            public int compare(final List<String> s1, final List<String> s2) {
                for (int i = 0; i < s1.size(); i++) {
                    if (!s1.get(i).equals(s2.get(i))) {
                        return s1.get(i).compareTo(s2.get(i));
                    }

                }
                return 0;
            }
        });

        List<String> ans = travelRoots.get(0);
        String[] answer = new String[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void dfs(final String prevRoot, final List<String> root, final String[][] tickets, int useTicketCount) {

        if (ticketCount == useTicketCount) {
            travelRoots.add(new ArrayList<>(root));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String arrive = ticket[0];
            String dest = ticket[1];


            if (prevRoot.equals(arrive) && !useTicket[i]) {
                useTicket[i] = true;
                root.add(dest);
                useTicketCount++;
                dfs(dest, root, tickets, useTicketCount);
                useTicketCount--;
                root.remove(root.size() - 1);
                useTicket[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"},
                {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        TravelRoot travelRoot = new TravelRoot();
        travelRoot.solution(tickets);
    }
}
