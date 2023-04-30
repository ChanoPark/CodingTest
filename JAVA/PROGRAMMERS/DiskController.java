package Programmers;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int end = 0;
        int answer = 0;
        int cnt = 0;
        int idx = 0;

        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end)
                queue.offer(jobs[idx++]);

            if (queue.isEmpty()) {
                end += jobs[idx][0] - end;
            } else {
                int[] j = queue.poll();
                answer += end - j[0] + j[1];
                end += j[1];
                cnt++;
            }
        }

        return answer / jobs.length;
    }
}
