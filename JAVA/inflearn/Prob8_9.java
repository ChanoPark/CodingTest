import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob8_9 {
    private static int n;
    private static int m;
    private static int[] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ch = new int[m];

        dfs(1, 0);
    }

    public static void dfs(int num, int idx) {
        if (idx == m) {
            for (int x : ch) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = num; i <= n; i++) {
                ch[idx] = i;
                dfs(i + 1, idx + 1);
            }
        }
    }
}
