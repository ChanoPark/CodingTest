import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ArrayList<Integer> 의 remove를 할 때, Integer.valueOf(1) 처럼 사용해야 Object를 remove함.(인덱스 대신)
 */
public class Prob8_6 {
    private static int[] arr;
    private static int[] current;
    private static int[] visited;
    private static int m;
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        visited = new int[n];
        current = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0);
    }

    public static void dfs(int level) {
        if (level == m) {
            for (int x : current) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    current[level] = arr[i];
                    visited[i] = 1;
                    dfs(level + 1);
                    visited[i] = 0;
                }
            }
        }
    }
}