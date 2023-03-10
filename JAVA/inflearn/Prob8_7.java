import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob8_7 {
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);

        dp = new int[n + 1][r + 1];
        System.out.println(recursive(n, r));
    }

    public static int recursive(int n, int r) {
        if (dp[n][r] != 0) return dp[n][r];
        else if (n - r == 1 || r == 1) return n;
        else if (n == 0 || r == n) return 1;

        return dp[n][r] = recursive(n - 1, r - 1) + recursive(n - 1, r);
    }
}
