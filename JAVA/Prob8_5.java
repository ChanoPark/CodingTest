import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Prob8_5 {
    private static int n;
    private static int m;
    private static Integer[] arr;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int count, int current) {
        if (count > answer || current > m) return;
        if (current == m) answer = count;
        else {
            for (int i = 0; i < n; i++) {
                dfs(count + 1, current + arr[i]);
            }
        }
    }
}
