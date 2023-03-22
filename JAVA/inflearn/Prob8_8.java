import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob8_8 {
    private static int[] b;
    private static int[] p;
    private static int[] ch;
    private static int n;
    private static int f;
    private static int[][] dy;
    private static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        f = Integer.parseInt(input[1]);

        p = new int[n];
        b = new int[n];
        ch = new int[n + 1];

        dy = new int[35][35];
        for (int i = 0; i < n; i++) {
            b[i] = getCombination(n - 1, i);
        }

        dfs(0, 0);
    }

    public static int getCombination(int n, int r) {
        if (dy[n][r] != 0) return dy[n][r];
        else if (n - r == 1 || r == 1) return n;
        else if (r == 0 || r == n) return 1;

        return dy[n][r] = getCombination(n - 1, r - 1) + getCombination(n - 1, r);
    }

    public static void dfs(int l, int sum) {
        if (flag) return;
        if (l == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + (p[l] * b[l]));
                    ch[i] = 0;
                }
            }
        }
    }
}
