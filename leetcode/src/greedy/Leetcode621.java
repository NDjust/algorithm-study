package greedy;

import java.util.*;

public class Leetcode621 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> priorityQueue = new PriorityQueue<>((t1,t2) -> t2.count - t1.count);

        for (Character character : map.keySet()) {
            priorityQueue.add(new Task(character, map.get(character)));
        }

        List<String> ans = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {

            List<Task> tasksList = new ArrayList<>();

            if (priorityQueue.size() > n) {
                for (int i = 0; i <= n; i++) {
                    Task poll = priorityQueue.poll();
                    ans.add(String.valueOf(poll.id));
                    poll.count -= 1;

                    if (poll.count > 0) {
                        tasksList.add(poll);
                    }
                }
                priorityQueue.addAll(tasksList);

            } else {
                int idleCount = n + 1 - priorityQueue.size();
                int currSize = priorityQueue.size();

                for (int i = 0; i < currSize; i++) {
                    Task poll = priorityQueue.poll();
                    ans.add(String.valueOf(poll.id));
                    poll.count -= 1;

                    if (poll.count > 0) {
                        tasksList.add(poll);
                    }
                }
                priorityQueue.addAll(tasksList);

                if (priorityQueue.isEmpty()) {
                    break;
                }

                for (int i = 0; i < idleCount; i++) {
                    ans.add("idle");
                }


            }
        }

        return ans.size();
    }

    private static class Task {
        char id;
        int count;

        public Task(final char id, final int count) {
            this.id = id;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        Leetcode621 leetcode621 = new Leetcode621();
        char[] tasks = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};

        int i = leetcode621.leastInterval(tasks, 2);
        System.out.println(i);
    }
}
