import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob8_4 {
    private static int[] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        visited = new int[m];
        dfs(0);
    }

    public static void dfs(int level) {
        if (level == m) {
            for (int x : visited) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                visited[level] = i;
                dfs(level + 1);
            }
        }
    }
}
