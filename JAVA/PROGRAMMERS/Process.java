package Programmers;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Job> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Job(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            int max = 0;
            int cnt = 0;
            for (int i = 0; i < queue.size(); i++) {
                Job job = queue.poll();
                if (max < job.priority) {
                    cnt = i;
                    max = job.priority;
                }
                queue.offer(job);
            }

            for (int i = 0; i < cnt; i++) {
                queue.offer(queue.poll());
            }

            if (queue.poll().getIdx() == location) return answer + 1;

            answer++;
        }


        return answer;
    }

    public static class Job {
        private int idx;
        private int priority;

        public Job(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        public int getIdx() {
            return this.idx;
        }
    }
}
