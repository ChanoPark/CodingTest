import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3_6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int lt = 0;
        int rt;
        int cnt;
        int next;
        int answer = 0;

        while (lt < n) {
            cnt = 0;
            rt = next = lt;
            while (cnt < k) {
                if (numbers[rt] == 0) {
                    cnt++;
                    if (cnt == 1) {
                        next = rt + 1;
                    }
                }

                if (rt != n - 1) rt++;
                else break;
            }

            while (numbers[rt] == 1) {
                if (rt != n - 1) rt++;
                else break;
            }

            answer = Math.max(answer, rt - lt);

            lt = next;
            if (rt == n - 1) break;
        }
        System.out.println(answer);
    }
}