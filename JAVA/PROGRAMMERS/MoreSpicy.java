package Programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer(s);

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) break;
            else if (pq.size() == 1) return -1;

            int f1 = pq.poll();
            int f2 = pq.poll();

            pq.offer(f1 + (f2 * 2));
            answer++;

        }

        return answer;
    }
}
