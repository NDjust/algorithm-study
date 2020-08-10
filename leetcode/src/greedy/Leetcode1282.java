package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, Group> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (map.containsKey(size))  {
                Group g = map.get(size);
                g.addId(i);
            } else {
                map.put(size, new Group(i, size));
            }
        }

        List<List<Integer>> answer = new ArrayList();

        for (int gSize : map.keySet()) {
            Group group = map.get(gSize);

            // group size 보다 많은 경우 subList로 나누기.
            if (gSize < group.ids.size()) {
                List<Integer> ids = group.ids;
                for (int j = 0; j < ids.size(); j += gSize) {
                    answer.add(ids.subList(j, j + gSize));
                }
            } else {
                answer.add(group.ids);
            }
        }

        return answer;
    }

    private static class Group {
        int groupSize;
        List<Integer> ids = new ArrayList();

        Group (int id, int groupSize) {
            this.groupSize = groupSize;
            ids.add(id);
        }

        public void addId(int id) {
            ids.add(id);
        }
    }
}
