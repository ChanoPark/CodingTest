import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob7_12 {
    public static int[][] graph;
    public static int n;
    public static int answer = 0;
    public static int[] visited;
    public static int[] path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new int[n + 1][n + 1];
        visited = new int[n + 1];
        path = new int[n];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            graph[n1][n2] = 1;
        }
        visited[1] = 1;
        path[0] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }

    public static void dfs(int p, int idx) {
        if (idx == n) {
            answer++;
            System.out.print("경로:");
            for (int x : path) {
                if (x != 0) System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[idx][i] == 1 && visited[i] == 0) {
                    path[p] = i;
                    visited[i] = 1;
                    dfs(p + 1, i);
                    visited[i] = 0;
                    path[p] = 0;
                }
            }
        }
    }
}
