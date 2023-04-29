package Programmers;

import java.util.*;

public class FeatureDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int cur = 0;
        int day = 2;

        while (cur < progresses.length) {
            int cnt = 0;
            while (cur < progresses.length && progresses[cur] + (speeds[cur] * day) >= 100) {
                cur++;
                cnt++;
            }

            if (cnt != 0) answer.add(cnt);

            day++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    //메모리 사용량 초과
//    public int[] solution(int[] progresses, int[] speeds) {
//        List<Integer> answer = new ArrayList<>();
//        Queue<Work> queue = new LinkedList<>();
//
//        for (int i = 0; i < speeds.length; i++) {
//            queue.offer(new Work(progresses[i], speeds[i]));
//        }
//
//        int day = 2;
//        while (!queue.isEmpty()) {
//            int cnt = 0;
//            while (queue.peek().progress + (day * queue.peek().speed) >= 100) {
//                cnt++;
//                queue.poll();
//            }
//            answer.add(cnt);
//        }
//
//
//        return answer.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    public static class Work {
//        private int progress;
//        private int speed;
//
//        public Work(int progress, int speed) {
//            this.progress = progress;
//            this.speed = speed;
//        }
//    }
}
