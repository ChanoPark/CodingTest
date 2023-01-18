import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] problems = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) problems[i] = Integer.parseInt(st.nextToken());

        int score = 0;
        int answer = 0;
        for (int k : problems) {
            if (k == 1) score++;
            else score = 0;

            answer += score;
        }
        System.out.println(answer);
    }
}
