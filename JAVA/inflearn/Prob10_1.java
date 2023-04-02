import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob10_1 {
    /**
     * 1칸 오르는 법 1가지 1
     * 2칸 오르는 법 2가지 11, 2
     * 3칸 오르는 법 3가지 111, 12, 21
     * 4칸 오르는 법 5가지 1111, 112, 121, 22
     * 5칸 오르는 법 8가지 11111, 1112, 1121, 1211, 2111, 122, 121, 221
     * F(n) = F(n-1) + F(n-2)
     * -> 어떻게 그 값을 도출해내는지. == n번째 계단으로 올 수 있는 방법이 뭔지? 1계단 전, 2계단 전.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

    }
}
