import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob8_1 {
    private static int[] arr;
    private static int[] visited;
    private static int n;
    private static int sum1 = 0;
    private static int sum2 = 0;
    private static boolean flag = true; //재귀호출을 바로 종료시킬 수 있는 플래그!
    private static String answer = "NO";

    public static void main(String[] args) throws Exception {
//        solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            sum2 += input;
        }
        visited[0] = 1;
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int idx) {
        sum1 += arr[idx];
        sum2 -= arr[idx];
        if (!flag || sum1 > sum2) return;
        if (sum1 == sum2) {
            answer = "YES";
            flag = false;
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(i);
                    visited[i] = 0;
                    sum1 -= arr[i];
                    sum2 += arr[i];
                }
            }
        }
    }


    private static int total = 0;

    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            total += input;
        }
        solution_dfs(0, 0);
    }

    private static void solution_dfs(int idx, int sum) {
        if (!flag || sum > total / 2) return;
        if (idx == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = false;
            }
        } else {
            solution_dfs(idx + 1, sum + arr[idx]);
            solution_dfs(idx + 1, sum);
        }
    }
}
