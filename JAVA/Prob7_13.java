import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Prob7_13 {
    public static List<ArrayList<Integer>> graph;
    public static int[] visited;
    public static int n;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        visited = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            graph.get(n1).add(n2);
        }

        visited[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(Integer idx) {
        if (idx == n) answer++;
        else {
            for (Integer x : graph.get(idx)) {
                if (visited[x] == 0) {
                    visited[x] = 1;
                    dfs(x);
                    visited[x] = 0;
                }
            }
        }
    }
}
