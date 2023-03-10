import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob8_3 {
    public static void greedy() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Problem[] problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(score, time);
        }

        Arrays.sort(problems);

        int answer = 0;
        int current = 0;

        for (Problem p : problems) {
            if (current + p.getTime() > m) continue;
            current += p.getTime();
            answer += p.getScore();
        }

        System.out.println(answer);
    }

    private static Problem[] problems;
    private static int n;
    private static int m;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        problems = new Problem[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(score, time);
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int time, int score) {
        if (time > m) return;
        if (idx > n - 1) {
            answer = Math.max(answer, score);
        } else {
            dfs(idx + 1, time + problems[idx].getTime(), score + problems[idx].getScore());
            dfs(idx + 1, time, score);
        }
    }

    public static class Problem implements Comparable<Problem> {
        private int score;
        private int time;
        private double standard;

        @Override
        public int compareTo(Problem o) {
            int res = Double.compare(o.getStandard(), this.standard);
            if (res == 0) res = o.getTime() - this.time;
            return res;
        }

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
            this.standard = (double) score / time;
        }

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        public double getStandard() {
            return standard;
        }
    }
}
