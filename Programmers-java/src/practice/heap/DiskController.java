package practice.heap;

import java.util.*;


class DiskController {

    static class Disk implements Comparable<Disk> {
        int startTime;
        int taskTime;

        public Disk(int startTime, int taskTime) {
            this.startTime = startTime;
            this.taskTime = taskTime;
        }

        @Override
        public int compareTo(Disk disk) {
            return this.taskTime - disk.taskTime;
        }
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);

        List<Disk> jobList = new ArrayList<>();

        for (int[] job : jobs) {
            jobList.add(new Disk(job[0], job[1]));
        }

        PriorityQueue<Disk> waitingJob = new PriorityQueue<>();

        int prev_end = 0;
        int sum = 0;

        while (!jobList.isEmpty() || !waitingJob.isEmpty()) {
            boolean isNew = false;

            Iterator<Disk> iterator = jobList.iterator();

            while (iterator.hasNext()) {
                Disk disk = iterator.next();
                if (disk.startTime > prev_end) {
                    break;
                }

                waitingJob.add(disk);
                iterator.remove();
            }

            if (waitingJob.isEmpty()) {
                waitingJob.add(jobList.get(0));
                jobList.remove(0);
                isNew = true;
            }

            Disk wJob = waitingJob.poll();


            if (isNew) {
                sum += wJob.taskTime;
                prev_end = wJob.taskTime + wJob.startTime;
            } else {
                sum += (wJob.taskTime + (prev_end - wJob.startTime));
                prev_end += wJob.taskTime;
            }
        }

        return (int) sum / jobs.length;
    }
}