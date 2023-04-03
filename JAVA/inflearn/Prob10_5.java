import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) coin[i] = Integer.parseInt(st.nextToken());

        int total = Integer.parseInt(br.readLine());
        int[] dp = new int[total + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= total; j++) {
//                if (dp[j] > dp[j - coin[i]]) {
//                    dp[j] = dp[j - coin[i]] + 1;
//                }
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }
        System.out.println(dp[total]);
    }
}
