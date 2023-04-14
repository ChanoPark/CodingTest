package Programmers;

import java.util.PriorityQueue;

public class Immigration {
    /**
     * 시간 초과 발생 -> 이분 탐색 필요
     *
     * @param n
     * @param times
     * @return
     */
    public long solution2(int n, int[] times) {
        long answer = 0;

        PriorityQueue<Person> pq = new PriorityQueue<>();
        for (int t : times) {
            pq.offer(new Person(t, t));
        }

        while (n > 0) {
            Person p = pq.poll();
            answer = p.getEnd();
            pq.offer(p.next(answer + p.getTime()));
            n--;
        }
        return answer;
    }

    public static class Person implements Comparable<Person> {
        private int time;
        private long end;

        public Person(int time, long end) {
            this.time = time;
            this.end = end;
        }

        public int getTime() {
            return this.time;
        }

        public long getEnd() {
            return this.end;
        }

        public Person next(long end) {
            this.end = end;
            return this;
        }

        @Override
        public int compareTo(Person o) {
            if (this.end == o.getEnd()) return this.time - o.getTime();
            else return (int) (this.end - o.getEnd());
        }
    }

    /**
     * 이분 탐색을 활용한 풀이
     * @param n
     * @param times
     * @return
     */
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = times[times.length - 1] * (long) n;
        long mid;
        long tmp;

        while (left <= right) {
            tmp = 0;
            mid = (left + right) / 2;

            for (int time : times) tmp += (mid / time);

            if (tmp >= n) {
                answer = mid;
                right = mid - 1;
            } else if (tmp < n) {
                left = mid + 1;
            }
        }
        return answer;
    }
}
