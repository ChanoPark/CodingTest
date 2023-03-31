import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob9_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            queue.offer(new Lecture(m, d));
        }

        while (!queue.isEmpty()) {
            Lecture lecture = queue.poll();
            int day = lecture.getDay();
            int money = lecture.getMoney();

            if (map.containsKey(day)) {
                while (day > 1) {
                    day--;
                    if (!map.containsKey(day)) {
                        map.put(day, money);
                        break;
                    }
                }
            } else {
                map.put(day, money);
            }
        }

        int answer = 0;
        for (Integer value : map.values()) {
            answer += value;
        }

        System.out.println(answer);
    }

    public static class Lecture implements Comparable<Lecture> {
        private int money;
        private int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }

        public int getMoney() {
            return money;
        }

        public int getDay() {
            return day;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.money == o.getMoney()) return o.getDay() - this.day;
            else return o.getMoney() - this.money;
        }
    }
}