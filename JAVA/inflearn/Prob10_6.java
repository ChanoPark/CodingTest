import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob10_6 {
    private static int n;
    private static int m;
    private static int answer;
    private static Problem[] problems;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        problems = new Problem[n];

        for (int i=0; i<n; i++) {
            inputs = br.readLine().split(" ");
            int score = Integer.parseInt(inputs[0]);
            int time = Integer.parseInt(inputs[1]);
            problems[i] = new Problem(score, time);
        }

        int[] dp = new int[m+1];

        for (int i=0; i<n; i++) {

            for (int j=m; j>=problems[i].getTime(); j--) {
                dp[j] = Math.max(dp[j], dp[j - problems[i].getTime()] + problems[i].getScore());
            }
        }

        System.out.println(dp[m]);

//        dfs(0, 0, 0);
//        System.out.println(answer);
    }

    public static void dfs(int i, int sum, int t) {
        if (t > m) return;
        else if (i > n-1) answer = Math.max(answer, sum);
        else {
            dfs(i + 1, sum + problems[i].getScore(), t + problems[i].getTime());
            dfs(i + 1, sum, t);
        }
    }

    public static class Problem {
        private int score;
        private int time;

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
